package com.artifactmmo.frump.smtest;

import com.artifactmmo.Client;
import com.artifactmmo.Data;
import com.artifactmmo.frump.Util;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.openapitools.client.model.CharacterSchema;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class StateMachine {
    private transient final CharWrapper charWrapper;
    private final String filePath;
    private final HashMap<String,State> states;
    private State currentState;

    public StateMachine(String filePath, CharWrapper cw) {
        this.charWrapper = cw;
        this.states = new HashMap<>();
        this.filePath = filePath;
        loadStates();
        this.currentState = states.get("Start");
    }

    private void loadStates() {
        this.states.clear();
        Gson gson = new GsonBuilder().create();
        Type stateListType = new TypeToken<List<State>>(){}.getType();
        if((new File(filePath)).isDirectory()){
            List<Path> files = findJsonFiles((new File(filePath)).toPath());
            for(Path p : files){
                List<State> ss = gson.fromJson(Util.readFromFile(p), stateListType);
                for (State s : ss) {
                    states.put(s.getName(), s);
                }
            }
        }
        else {
            List<State> ss = gson.fromJson(Util.readFromFile(filePath), stateListType);
            for (State s : ss) {
                states.put(s.getName(), s);
            }
        }
    }

    public static List<Path> findJsonFiles(Path startPath) {
        List<Path> pat = new ArrayList<>();
        try (Stream<Path> paths = Files.walk(startPath)) {
            paths.filter(Files::isRegularFile)
                    .filter(path -> path.toString().endsWith(".json"))
                    .forEach(pat::add);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return pat;
    }


    public void process() {
        //check preTransitions
        String nextStateName = checkPreTransitions();
        if (nextStateName != null) {
            currentState = states.get(nextStateName);
            return;
        }
        //perform action
        if (currentState.getAction() != null) {
            performAction(currentState.getAction());
        }
        // Check post transitions
        nextStateName = checkPostTransitions();
        if (nextStateName != null) {
            currentState = states.get(nextStateName);
            return;
        }
    }

    private String checkPostTransitions() {
        for (Transition transition : currentState.getPostTransitions()) {
            if (evaluateConditions(transition.getConditions(),false)) {
                return transition.getTargetState();
            }
        }
        return null;
    }

    private String checkPreTransitions() {
        for (Transition transition : currentState.getPreTransitions()) {
            if (evaluateConditions(transition.getConditions(),true)) {
                return transition.getTargetState();
            }
        }
        return null;
    }

    private boolean evaluateConditions(List<String> conditions, boolean preCheck) {
        for(String condition : conditions){
            boolean eval = evaluateCondition(condition);
            System.out.println("[StateMachine] Check Condition: "+condition + " Returned:"+eval + " Precheck:"+preCheck);
            if(!eval){
                return false;
            }
        }
        return true;
    }

    private boolean evaluateCondition(String condition) {
        CharacterSchema cs = charWrapper.getCharacter();
        Client client = charWrapper.getClient();
        if (condition.startsWith("bankContains") || condition.startsWith("bankNotContains")) {
            return evaluateBankCondition(condition, cs, client);
        }
        else if (condition.startsWith("woodcutting")) {
            return evaluateConditionByPrefix(condition, "woodcutting", cs.getWoodcuttingLevel());
        } else if (condition.startsWith("mining")) {
            return evaluateConditionByPrefix(condition, "mining", cs.getMiningLevel());
        } else if (condition.startsWith("fishing")) {
            return evaluateConditionByPrefix(condition, "fishing", cs.getFishingLevel());
        } else if (condition.startsWith("gearcrafting")) {
            return evaluateConditionByPrefix(condition, "gearcrafting", cs.getGearcraftingLevel());
        } else if (condition.startsWith("weaponcrafting")) {
            return evaluateConditionByPrefix(condition, "weaponcrafting", cs.getWeaponcraftingLevel());
        } else if (condition.startsWith("jewelrycrafting")) {
            return evaluateConditionByPrefix(condition, "jewelrycrafting", cs.getJewelrycraftingLevel());
        } else if (condition.startsWith("cooking")) {
            return evaluateConditionByPrefix(condition, "cooking", cs.getCookingLevel());
        }
        else if (condition.startsWith("accountName")) {
            String accName = condition.substring(11);
            return charWrapper.getCharacter().getName().equals(accName);
        }
        switch(condition){
            case "true":
                return true;
            case "false":
                return false;
            case "invFull":
                return charWrapper.getClient().countInventory(charWrapper.getCharacter()) >= cs.getInventoryMaxItems();
            case "invEmpty":
                return charWrapper.getClient().countInventory(charWrapper.getCharacter()) == 0;
            case "freeInvSpace":
                return charWrapper.getClient().countInventory(charWrapper.getCharacter()) < cs.getInventoryMaxItems();
        }
        System.out.println("[StateMachine] UnknownCondition "+condition);
        return false;
    }

    private boolean evaluateBankCondition(String condition, CharacterSchema cs, Client client) {
        String prefix = condition.startsWith("bankNotContains") ? "bankNotContains" : "bankContains";
        String regex = prefix + "(\\d+)([a-zA-Z_]+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(condition);

        if (matcher.find()) {
            int quantity = Integer.parseInt(matcher.group(1));
            String itemName = matcher.group(2);
            boolean contains = client.bankContains(cs, itemName, quantity);

            // Return the opposite of the result if the prefix is "bankNotContains"
            return prefix.equals("bankNotContains") ? !contains : contains;
        } else {
            System.out.println("[StateMachine] Bad Condition: " + condition);
            return false;
        }
    }

    private boolean evaluateConditionByPrefix(String condition, String prefix, int statLevel) {
        String regex = prefix + "(GreaterThanEqual|LessThanEqual|GreaterThan|LessThan|EqualTo|NotEqualTo)(\\d+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(condition);

        if (matcher.find()) {
            String comparisonType = matcher.group(1);
            int threshold = Integer.parseInt(matcher.group(2));

            switch (comparisonType) {
                case "GreaterThan":
                    return statLevel > threshold;
                case "GreaterThanEqual":
                    return statLevel >= threshold;
                case "LessThan":
                    return statLevel < threshold;
                case "LessThanEqual":
                    return statLevel <= threshold;
                case "EqualTo":
                    return statLevel == threshold;
                case "NotEqualTo":
                    return statLevel != threshold;
                default:
                    System.out.println("[StateMachine] Unknown Comparison Type: " + comparisonType);
                    return false;
            }
        } else {
            System.out.println("[StateMachine] Bad Condition: " + condition);
            return false;
        }
    }

    private void performAction(String action) {
        if(!charWrapper.getClient().cooldownExpired(charWrapper.getCharacter())){
            return;
        }
        switch(action){
            case "bankAll":
                charWrapper.getClient().bankAll(charWrapper.getCharacter());
                break;
            case "bankAny":
                charWrapper.getClient().bankAny(charWrapper.getCharacter());
                break;
            case "MineCopper":
                charWrapper.getClient().gather(charWrapper.getCharacter(), Data.LOC_COPPER);
                break;
            case "MineIron":
                charWrapper.getClient().gather(charWrapper.getCharacter(), Data.LOC_IRON);
                break;
            case "MineGold":
                charWrapper.getClient().gather(charWrapper.getCharacter(), Data.LOC_GOLD);
                break;
            case "MineCoal":
                charWrapper.getClient().gather(charWrapper.getCharacter(), Data.LOC_COAL);
                break;
            case "FishGudgeon":
                charWrapper.getClient().gather(charWrapper.getCharacter(), Data.LOC_GUDGEON);
                break;
            case "FishShrimp":
                charWrapper.getClient().gather(charWrapper.getCharacter(), Data.LOC_SHRIMP);
                break;
            case "FishTrout":
                charWrapper.getClient().gather(charWrapper.getCharacter(), Data.LOC_TROUT);
                break;
            case "FishBass":
                charWrapper.getClient().gather(charWrapper.getCharacter(), Data.LOC_BASS);
                break;
            case "CutAsh":
                charWrapper.getClient().gather(charWrapper.getCharacter(), Data.LOC_ASH);
                break;
            case "CutSpruce":
                charWrapper.getClient().gather(charWrapper.getCharacter(), Data.LOC_SPRUCE);
                break;
            case "CutBirch":
                charWrapper.getClient().gather(charWrapper.getCharacter(), Data.LOC_BIRCH);
                break;
            case "CutDeadTree":
                charWrapper.getClient().gather(charWrapper.getCharacter(), Data.LOC_DEAD_TREE);
                break;
            default:
                System.out.println("[StateMachine] UnknownAction "+action);
                break;
        }
    }
}
