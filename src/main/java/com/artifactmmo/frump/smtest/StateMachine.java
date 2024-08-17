package com.artifactmmo.frump.smtest;

import com.artifactmmo.Client;
import com.artifactmmo.Data;
import com.artifactmmo.frump.Util;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.openapitools.client.model.CharacterSchema;

import java.io.File;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static com.artifactmmo.Data.*;

public class StateMachine {
    private transient final CharWrapper charWrapper;
    private final String filePath;
    private final HashMap<String, State> states;
    private State previousState;
    private State currentState;
    private static final String[] RESERVED_STATE_NAMES = new String[]{"return","action"};

    private final boolean debug;

    public StateMachine(String filePath, CharWrapper cw, boolean debug) {
        this.charWrapper = cw;
        this.states = new HashMap<>();
        this.filePath = filePath;
        loadStates();
        this.currentState = states.get("Start");
        this.debug = debug;
    }

    private void loadStates() {
        this.states.clear();
        Gson gson = new GsonBuilder().create();
        Type stateListType = new TypeToken<List<State>>() {
        }.getType();
        if ((new File(filePath)).isDirectory()) {
            List<Path> files = findJsonFiles((new File(filePath)).toPath());
            for (Path p : files) {
                List<State> ss = gson.fromJson(Util.readFromFile(p), stateListType);
                for (State s : ss) {
                    if (!reservedStateName(s.getName())) {
                        states.put(s.getName(), s);
                    } else {
                        System.out.println("[StateMachine] Reserved Statename used, please correct.");
                    }
                }
            }
        } else {
            List<State> ss = gson.fromJson(Util.readFromFile(filePath), stateListType);
            for (State s : ss) {
                if (!reservedStateName(s.getName())) {
                    states.put(s.getName(), s);
                } else {
                    System.out.println("[StateMachine] Reserved Statename used, please correct.");
                }
            }
        }
    }

    public boolean reservedStateName(String s) {
        for (String a : RESERVED_STATE_NAMES) {
            if (a.equals(s)) {
                return true;
            }
        }
        return false;
    }

    public static List<Path> findJsonFiles(Path startPath) {
        List<Path> pat = new ArrayList<>();
        try (Stream<Path> paths = Files.walk(startPath)) {
            paths.filter(Files::isRegularFile)
                    .filter(path -> path.toString().endsWith(".json"))
                    .forEach(pat::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pat;
    }


    public void process() {
        //on cooldown, we can't do shit.
        if (!charWrapper.getClient().cooldownExpired(charWrapper.getCharacter())) {
            return;
        }
        //check preTransitions
        String nextStateName = checkPreTransitions();
        if (nextStateName != null) {
            if (nextStateName.equals("return")) {
                currentState = previousState;
            }
            else if(nextStateName.equals("action")){
                return;
            }
            else {
                previousState = currentState;
                currentState = states.get(nextStateName);
                return;
            }
        }
        //perform action
        if (currentState.getAction() != null) {
            performAction(currentState.getAction(), currentState.getArgs());
        }
        // Check post transitions
        nextStateName = checkPostTransitions();
        if (nextStateName != null) {
            if (nextStateName.equals("return")) {
                currentState = previousState;
            }else if(nextStateName.equals("action")){
                return;
            } else {
                previousState = currentState;
                currentState = states.get(nextStateName);
            }
        }
    }

    private String checkPostTransitions() {
        return checkTransitions(currentState.getPostTransitions(), false);
    }

    private String checkPreTransitions() {
        return checkTransitions(currentState.getPreTransitions(), true);
    }

    private String checkTransitions(List<Transition> transitions, boolean preCheck) {
        for (Transition transition : transitions) {
            if (evaluateConditions(transition.getConditions(), preCheck)) {
                if (transition.getAction() != null) {
                    performAction(transition.getAction(), transition.getArgs());
                    return "action";
                }
                if (transition.getTargetState() != null) {
                    return transition.getTargetState();
                }
            }
        }
        return null;
    }

    private boolean evaluateConditions(List<String> conditions, boolean preCheck) {
        for (String condition : conditions) {
            boolean eval = evaluateCondition(condition);
            if(debug) {
                System.out.println("[StateMachine] Check Condition: " + condition + " Returned:" + eval + " Precheck:" + preCheck);
            }
            if (!eval) {
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
        else if (condition.startsWith("invContains") || condition.startsWith("invNotContains")) {
            return evaluateInvCondition(condition, cs, client);
        }
        else if (condition.startsWith("bankOrInvContains") || condition.startsWith("bankOrInvNotContains")) {
            return evaluateBankOrInvCondition(condition, cs, client);
        } else if (condition.startsWith("woodcutting")) {
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
        } else if (condition.startsWith("combat")) {
            return evaluateConditionByPrefix(condition, "combat", cs.getLevel());
        } else if (condition.startsWith("accountName")) {
            String accName = condition.substring(11);
            return charWrapper.getCharacter().getName().equals(accName);
        } else if(condition.startsWith("equipped")){
            return equipped(condition.substring(8).toLowerCase(), cs, client);
        }else if(condition.startsWith("!equipped")){
            boolean notEquipped = !equipped(condition.substring(9).toLowerCase(), cs, client);
            System.out.println(notEquipped + " is notEquipped");
            return notEquipped;
        }
        switch (condition) {
            case "true":
                return true;
            case "false":
                return false;
            case "invFull":
                return charWrapper.getClient().countInventory(charWrapper.getCharacter()) >= cs.getInventoryMaxItems();
            case "invEmpty":
                return charWrapper.getClient().countInventory(charWrapper.getCharacter()) == 0;
            case "freeInvSpace":
                return charWrapper.getClient().countInventory(charWrapper.getCharacter()) < cs.getInventoryMaxItems()-10;
            case "!freeInvSpace":
                return charWrapper.getClient().countInventory(charWrapper.getCharacter()) >= cs.getInventoryMaxItems()-10;
        }
        System.out.println("[StateMachine] UnknownCondition " + condition);
        return false;
    }


    private boolean equipped(String slot, CharacterSchema cs, Client client) {
        switch(slot){
            case "weapon":
                return !charWrapper.getCharacter().getWeaponSlot().equals("");
            case "shield":
                return !charWrapper.getCharacter().getShieldSlot().equals("");
            case "boots":
                return !charWrapper.getCharacter().getBootsSlot().equals("");
            case "helmet":
                return !charWrapper.getCharacter().getHelmetSlot().equals("");
            case "ring1":
                return !charWrapper.getCharacter().getRing1Slot().equals("");
            case "ring2":
                return !charWrapper.getCharacter().getRing2Slot().equals("");
            case "body":
                return !charWrapper.getCharacter().getBodyArmorSlot().equals("");
            case "leg":
                return !charWrapper.getCharacter().getLegArmorSlot().equals("");
            case "amulet":
                return !charWrapper.getCharacter().getAmuletSlot().equals("");
            case "artifact1":
                return !charWrapper.getCharacter().getArtifact1Slot().equals("");
            case "artifact2":
                return !charWrapper.getCharacter().getArtifact2Slot().equals("");
            case "artifact3":
                return !charWrapper.getCharacter().getArtifact3Slot().equals("");
        }
        return false;
    }

    private boolean evaluateInvCondition(String condition, CharacterSchema cs, Client client) {
        String prefix = condition.startsWith("invNotContains") ? "invNotContains" : "invContains";
        String regex = prefix + "(\\d+)([a-zA-Z_]+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(condition);

        if (matcher.find()) {
            int quantity = Integer.parseInt(matcher.group(1));
            String itemName = matcher.group(2);
            boolean contains = client.invContains(cs, itemName, quantity);
            System.out.println("Does inv contain "+itemName+" "+quantity + "  "+contains);
            return prefix.equals("invNotContains") ? !contains : contains;
        } else {
            System.out.println("[StateMachine] Bad Condition: " + condition);
            return false;
        }
    }

    private void withdraw(String condition, CharacterSchema cs, Client client) {
        String regex="withdraw(?:Max)?(\\d*)([a-zA-Z_]+)";
        Pattern pattern= Pattern.compile(regex);
        Matcher matcher= pattern.matcher(condition);
        boolean max= condition.startsWith("withdrawMax");

        if (matcher.find()) {
            String itemName= matcher.group(2);
            int quantity;

            if (max) {
                quantity = cs.getInventoryMaxItems() - client.countInventory(cs);
            } else {
                quantity = matcher.group(1).isEmpty() ? 1 : Integer.parseInt(matcher.group(1));
            }

            client.withdraw(cs, itemName, quantity);
        } else {
            System.out.println("[StateMachine] Bad Condition: " + condition);
        }
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

            return prefix.equals("bankNotContains") != contains;
        } else {
            System.out.println("[StateMachine] Bad Condition: " + condition);
            return false;
        }
    }

    private boolean evaluateBankOrInvCondition(String condition, CharacterSchema cs, Client client) {
        String prefix = condition.startsWith("bankOrInvNotContains") ? "bankOrInvNotContains" : "bankOrInvContains";
        String regex = prefix + "(\\d+)([a-zA-Z_]+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(condition);

        if (matcher.find()) {
            int quantity = Integer.parseInt(matcher.group(1));
            String itemName = matcher.group(2);
            boolean contains = client.bankOrInventoryContains(cs, itemName, quantity);

            return prefix.equals("bankOrInvNotContains") != contains;
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

    private void performAction(String action, String args) {
        if(debug) {
            System.out.println("[StateMachine] Action:"+action+" Args:"+args);
        }
        if(action.startsWith("withdraw")){
            withdraw(action, charWrapper.getCharacter(), charWrapper.getClient());
            return;
        }
        else if(action.startsWith("make")){
            make(action,args, charWrapper.getCharacter(), charWrapper.getClient());
            return;
        }
        else if(action.startsWith("equip")){
            System.out.println("Equip "+action.substring(5) + " " + args);
            charWrapper.getClient().equip(charWrapper.getCharacter(),action.substring(5),args);
            return;
        }
        switch (action) {
            case "unequip":
                charWrapper.getClient().unequip(charWrapper.getCharacter(),args);
                break;
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
            case "print":
                System.out.println("[Script] " + args);
                break;
            case "attackChickens":
                charWrapper.getClient().attack(charWrapper.getCharacter(), Data.LOC_CHICKENS);
                break;
            case "attackCows":
                charWrapper.getClient().attack(charWrapper.getCharacter(), Data.LOC_COWS);
                break;
            case "attackPigs":
                charWrapper.getClient().attack(charWrapper.getCharacter(), Data.LOC_PIGS);
                break;
            case "attackWolfs":
                charWrapper.getClient().attack(charWrapper.getCharacter(), Data.LOC_WOLF);
                break;
            case "attackSerpents":
                charWrapper.getClient().attack(charWrapper.getCharacter(), Data.LOC_SERPENT);
                break;
            case "attackMushMushs":
                charWrapper.getClient().attack(charWrapper.getCharacter(), Data.LOC_MUSHMUSH);
                break;
            case "attackOwlBears":
                charWrapper.getClient().attack(charWrapper.getCharacter(), Data.LOC_OWLBEAR);
                break;
            case "attackYellowSlime":
                charWrapper.getClient().attack(charWrapper.getCharacter(), Data.LOC_YELLOW_SLIME);
                break;
            case "attackBlueSlime":
                charWrapper.getClient().attack(charWrapper.getCharacter(), Data.LOC_BLUE_SLIME);
                break;
            case "attackGreenSlime":
                charWrapper.getClient().attack(charWrapper.getCharacter(), Data.LOC_GREEN_SLIME);
                break;

            default:
                System.out.println("[StateMachine] UnknownAction " + action);
                break;
        }
    }

    private void make(String action, String args, CharacterSchema cs, Client client) {
        String regex="make(?:Max)?(\\d*)([a-zA-Z_]+)";
        Pattern pattern= Pattern.compile(regex);
        Matcher matcher= pattern.matcher(action);
        boolean max= action.startsWith("makeMax");

        if (positionCheck(args, cs, client)) {
            return;
        }

        if (matcher.find()) {
            String itemName= matcher.group(2);
            int quantity;

            if (max) {
                quantity = cs.getInventoryMaxItems() - client.countInventory(cs);
            } else {
                quantity = matcher.group(1).isEmpty() ? 1 : Integer.parseInt(matcher.group(1));
            }

            client.craft(cs, itemName, quantity);
        } else {
            System.out.println("[StateMachine] Bad Condition: " + action);
        }
    }

    private boolean positionCheck(String args, CharacterSchema cs, Client client) {
        switch(args){
            case "gear":
                if(!Client.posEqual(cs,LOC_WORKSHOP_GEAR)){
                    client.actionMove(cs,LOC_WORKSHOP_GEAR);
                    return true;
                }
                break;
            case "mining":
                if(!Client.posEqual(cs,LOC_WORKSHOP_MINING)){
                    client.actionMove(cs,LOC_WORKSHOP_MINING);
                    return true;
                }
                break;
            case "woodcutting":
                if(!Client.posEqual(cs,LOC_WORKSHOP_WOODCUTTING)){
                    client.actionMove(cs,LOC_WORKSHOP_WOODCUTTING);
                    return true;
                }
                break;
            case "jewelery":
                if(!Client.posEqual(cs,LOC_WORKSHOP_JEWELERY)){
                    client.actionMove(cs,LOC_WORKSHOP_JEWELERY);
                    return true;
                }
                break;
            case "weapon":
                if(!Client.posEqual(cs,LOC_WORKSHOP_WEAPON)){
                    client.actionMove(cs,LOC_WORKSHOP_WEAPON);
                    return true;
                }
                break;
            case "cooking":
                if(!Client.posEqual(cs,LOC_WORKSHOP_COOKING)){
                    client.actionMove(cs,LOC_WORKSHOP_COOKING);
                    return true;
                }
                break;
        }
        return false;
    }

    public int size() {
        return states.size();
    }
}
