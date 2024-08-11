package com.artifactmmo.frump;

import com.artifactmmo.Client;
import org.openapitools.client.model.*;

import java.util.HashMap;
import java.util.List;
import static com.artifactmmo.Data.*;

public class OldMain {
    static Client client;
    static String USERNAME_PREFIX = "Frumpy";



    static HashMap<String,Boolean> BANKUP  = new HashMap<>();



    public static void main(String[] args) throws InterruptedException {
        client = new Client(Util.loadToken());
        //makeCharCheck();
        List<CharacterSchema> chars = client.getMyCharacters();
        for (CharacterSchema cs : chars) {
            new Thread(new Runnable(){
                @Override
                public void run() {
                    String name = cs.getName();
                    if(!BANKUP.containsKey(cs.getName())){
                        BANKUP.put(cs.getName(),false);
                    }
                    while(true){
                        try {
                            CharacterSchema cs2 = client.getCharacter(name).getData();
                            try {
                                runChar(cs2, BANKUP.get(cs.getName()));
                                Thread.sleep(500);
                            } catch (Exception e) {
                                System.out.println("---" + cs2.getName() + "---");
                                e.printStackTrace();
                                BANKUP.replace(cs2.getName(), true);
                            }
                        }catch(Exception e){
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
        /*while(true){
            try {
                chars = client.getMyCharacters();
                for (CharacterSchema cs : chars) {
                    if(!BANKUP.containsKey(cs.getName())){
                        BANKUP.put(cs.getName(),false);
                    }
                    try {
                        runChar(cs,BANKUP.get(cs.getName()));
                    } catch (Exception e) {
                        System.out.println("---" + cs.getName() + "---");
                        e.printStackTrace();
                        BANKUP.replace(cs.getName(),true);
                    }
                }
            }catch(Exception e){
                for(String key : BANKUP.keySet()){
                    BANKUP.replace(key,true);
                }
                e.printStackTrace();
            }
            Thread.sleep(100);
        }*/
    }

    private static void runChar(CharacterSchema cs, boolean bank) {
        if(!client.cooldownExpired(cs)){
            return;
        }
        if(bank || cs.getInventory().size() > cs.getInventoryMaxItems()-2){
            bankAll(cs);
            return;
        }
        if(cs.getLevel() < 3){
            //kill chickens till level 3;
            client.attack(cs,LOC_CHICKENS);
            System.out.println(cs.getName() + " Fight(2)!, i have "+cs.getXp()+"xp at level "+cs.getLevel());
            return;
        }
        //need weapon, we are at level 3 now.
        else if((cs.getWeaponSlot().equals("") || cs.getWeaponSlot().equals("wooden_stick")) && cs.getLevel() < 4){
            doWoodenStaff(cs);
            return;
        }
        else if(checkSkills(cs,10,LOC_ASH,LOC_COPPER,LOC_GUDGEON)){
            return;
        }
        else if(cs.getLevel() < 5){
            //kill chickens till level 5;
            client.attack(cs,LOC_CHICKENS);
            System.out.println(cs.getName() + " Fight(2)!, i have "+cs.getXp()+"xp at level "+cs.getLevel());
            return;
        }
        else if(doCook(cs,1)){
            return;
        }
        else if(doSmelt(cs,1)){
            return;
        }
        else if(doPlank(cs,1)){
            return;
        }
        else if(basicCopperGear(cs)){
            return;
        }
        else if(cs.getWeaponcraftingLevel() < 10 || cs.getJewelrycraftingLevel() < 10){
            client.gather(cs,LOC_COPPER);
            return;
        }
        else if(cs.getGearcraftingLevel() < 10){
            client.gather(cs,LOC_ASH);
            return;
        }
        else if(cs.getCookingLevel() < 10){
            client.gather(cs,LOC_GUDGEON);
            return;
        }
        else if(cs.getLevel() < 10){
            //kill yellow slime till 10 ?
            client.attack(cs,LOC_YELLOW_SLIME);
            System.out.println(cs.getName() + " Fight(2)!, i have "+cs.getXp()+"xp at level "+cs.getLevel());
            return;
        }
        else if(cs.getLevel() < 12){
            //kill yellow slime till 10 ?
            client.attack(cs,LOC_COWS);
            System.out.println(cs.getName() + " Fight(2)!, i have "+cs.getXp()+"xp at level "+cs.getLevel());
            return;
        }
        else if(checkSkills(cs,20,LOC_SPRUCE,LOC_COAL,LOC_SHRIMP)){
            return;
        }
        else if(doCook(cs,2)){
            return;
        }
        else if(doSmelt(cs,2)){
            return;
        }
        else if(doPlank(cs,2)){
            return;
        }
        else if(basicIronGear(cs)){
            return;
        }
        else{
            //kill chickens FOREVERRRRRRR
            client.attack(cs,LOC_CHICKENS);
            System.out.println(cs.getName() + " Fight(2)!, i have "+cs.getXp()+"xp at level "+cs.getLevel());
            return;
        }
    }

    private static boolean basicIronGear(CharacterSchema cs) {
        if(cs.getLevel() >= 20){
            return false;
        }
        else if(client.makeAndEquip(cs,LOC_WORKSHOP_GEAR, "iron_boots", cs.getBootsSlot(), "boots", REAG_IRON_BOOTS)){
            return true;
        }
        else if(client.makeAndEquip(cs,LOC_WORKSHOP_GEAR, "iron_helmet", cs.getHelmetSlot(), "helmet", REAG_IRON_HELMET)){
            return true;
        }
        else if(client.makeAndEquip(cs,LOC_WORKSHOP_JEWELERY, "iron_ring", cs.getRing1Slot(), "ring1", REAG_IRON_RING)){
            return true;
        }
        else if(client.makeAndEquip(cs,LOC_WORKSHOP_JEWELERY, "iron_ring", cs.getRing2Slot(), "ring2", REAG_IRON_RING)){
            return true;
        }
        else if(client.makeAndEquip(cs,LOC_WORKSHOP_WEAPON, "iron_sword", cs.getWeaponSlot(), "weapon", REAG_IRON_SWORD)){
            return true;
        }
       /* else if(client.makeAndEquip(cs,LOC_WORKSHOP_GEAR, "wooden_shield", cs.getShieldSlot(), "shield", REAG_WOODEN_SHIELD)){
            return true;
        }*/
        else if(cs.getGearcraftingLevel() > 5 && client.makeAndEquip(cs,LOC_WORKSHOP_GEAR, "iron_legs_armor", cs.getLegArmorSlot(), "leg_armor", REAG_IRON_LEGS)){
            return true;
        }
        else if(cs.getGearcraftingLevel() > 5 && client.makeAndEquip(cs,LOC_WORKSHOP_GEAR, "iron_armor", cs.getBodyArmorSlot(), "body_armor", REAG_IRON_ARMOR)){
            return true;
        }
        else if(cs.getWeaponcraftingLevel() < 10 && client.make(cs,LOC_WORKSHOP_WEAPON, "iron_sword", REAG_IRON_SWORD,false)){
            return true;
        }
        else if(cs.getJewelrycraftingLevel() < 10 && client.make(cs,LOC_WORKSHOP_JEWELERY, "iron_ring", REAG_IRON_RING,false)){
            return true;
        }
        return false;
    }

    private static boolean basicCopperGear(CharacterSchema cs) {
        if(cs.getLevel() >= 10){
            return false;
        }
        else if(client.makeAndEquip(cs,LOC_WORKSHOP_GEAR, "copper_boots", cs.getBootsSlot(), "boots", REAG_COPPER_BOOTS)){
            return true;
        }
        else if(client.makeAndEquip(cs,LOC_WORKSHOP_GEAR, "copper_helmet", cs.getHelmetSlot(), "helmet", REAG_COPPER_HELMET)){
            return true;
        }
        else if(client.makeAndEquip(cs,LOC_WORKSHOP_JEWELERY, "copper_ring", cs.getRing1Slot(), "ring1", REAG_COPPER_RING)){
            return true;
        }
        else if(client.makeAndEquip(cs,LOC_WORKSHOP_JEWELERY, "copper_ring", cs.getRing2Slot(), "ring2", REAG_COPPER_RING)){
            return true;
        }
        else if(client.makeAndEquip(cs,LOC_WORKSHOP_WEAPON, "copper_dagger", cs.getWeaponSlot(), "weapon", REAG_COPPER_DAGGER)){
            return true;
        }
        else if(client.makeAndEquip(cs,LOC_WORKSHOP_GEAR, "wooden_shield", cs.getShieldSlot(), "shield", REAG_WOODEN_SHIELD)){
            return true;
        }
        else if(cs.getGearcraftingLevel() > 5 && client.makeAndEquip(cs,LOC_WORKSHOP_GEAR, "copper_legs_armor", cs.getLegArmorSlot(), "leg_armor", REAG_COPPER_LEGS)){
            return true;
        }
        else if(cs.getGearcraftingLevel() > 5 && client.makeAndEquip(cs,LOC_WORKSHOP_GEAR, "copper_armor", cs.getBodyArmorSlot(), "body_armor", REAG_COPPER_ARMOR)){
            return true;
        }
        else if(cs.getWeaponcraftingLevel() < 10 && client.make(cs,LOC_WORKSHOP_WEAPON, "copper_dagger", REAG_COPPER_DAGGER,false)){
            return true;
        }
        else if(cs.getJewelrycraftingLevel() < 10 && client.make(cs,LOC_WORKSHOP_JEWELERY, "copper_ring", REAG_COPPER_RING,false)){
            return true;
        }
        else if(cs.getGearcraftingLevel() < 10 && client.make(cs,LOC_WORKSHOP_GEAR, "wooden_shield", REAG_WOODEN_SHIELD,false)){
            return true;
        }
        return false;
    }



    private static void bankAll(CharacterSchema cs) {
        if(!client.posEqual(cs,LOC_BANK)){
            client.actionMove(cs,LOC_BANK);
            return;
        }
        client.bankAll(cs);
        BANKUP.replace(cs.getName(),false);
    }

    public static boolean checkSkills(CharacterSchema cs, int level, DestinationSchema wood, DestinationSchema ore, DestinationSchema fish){
        if(cs.getWoodcuttingLevel() < level){
            client.gather(cs,wood);
            return true;
        }
        else if(cs.getMiningLevel() < level){
            client.gather(cs,ore);
            return true;
        }
        else if(cs.getFishingLevel() < level){
            client.gather(cs,fish);
            return true;
        }
        return false;
    }

    private static boolean doPlank(CharacterSchema cs, int seq) {
        if(seq == 1) {
            if ((client.bankContains(cs, "ash_wood", 100) || client.hasItem(cs, "ash_wood", 6)) && cs.getLevel() < 10) {
                if (!client.hasItem(cs, "ash_wood", 6)) {
                    client.withdraw(cs, "ash_wood", 90);
                    return true;
                }
                plank(cs, "ash_plank",client.countItem(cs,"ash_wood")/6);
                return true;
            }
        }
        if(seq == 2) {
            if ((client.bankContains(cs, "spruce_wood", 100) || client.hasItem(cs, "spruce_wood", 6)) && cs.getLevel() < 10) {
                if (!client.hasItem(cs, "spruce_wood", 6)) {
                    client.withdraw(cs, "spruce_wood", 90);
                    return true;
                }
                plank(cs, "spruce_plank",client.countItem(cs,"spruce_wood")/6);
                return true;
            }
        }
        return false;
    }

    private static void plank(CharacterSchema cs, String plank,int amnt) {
        if(!client.posEqual(cs,LOC_WORKSHOP_WOODCUTTING)){
            client.actionMove(cs,LOC_WORKSHOP_WOODCUTTING);
            return;
        }
        client.craft(cs, plank, amnt);
        return;
    }

    private static boolean doSmelt(CharacterSchema cs, int seq) {
        if(seq == 1) {
            if (client.bankContains(cs, "copper_ore", 100) || client.hasItem(cs, "copper_ore", 6)) {
                if (!client.hasItem(cs, "copper_ore", 6)) {
                    client.withdraw(cs, "copper_ore", 90);
                    return true;
                }
                smelt(cs, "copper",client.countItem(cs,"copper_ore")/6);
                return true;
            }
        }
        else if(seq == 2) {
            if (client.bankContains(cs, "iron_ore", 100) || client.hasItem(cs, "iron_ore", 6)) {
                if (!client.hasItem(cs, "iron_ore", 6)) {
                    client.withdraw(cs, "iron_ore", 90);
                    return true;
                }
                smelt(cs, "iron",client.countItem(cs,"iron_ore")/6);
                return true;
            }
        }
        return false;
    }

    private static void smelt(CharacterSchema cs, String metal,int amnt) {
        if(!client.posEqual(cs,LOC_WORKSHOP_MINING)){
            client.actionMove(cs,LOC_WORKSHOP_MINING);
            return;
        }
        client.craft(cs, metal, amnt);
        return;
    }

    private static boolean doCook(CharacterSchema cs,int seq) {
        if(seq == 1) {
            if (cs.getCookingLevel() < 10 && (client.bankContains(cs, "gudgeon", 100) || client.hasItem(cs, "gudgeon", 1))) {
                if (!client.hasItem(cs, "gudgeon", 1)) {
                    client.withdraw(cs, "gudgeon", 90);
                    return true;
                }
                cook(cs, "cooked_gudgeon",client.countItem(cs,"gudgeon")/6);
                return true;
            } else if (cs.getCookingLevel() < 10 && !client.bankContains(cs, "gudgeon", 100)) {
                client.gather(cs, LOC_GUDGEON);
                return true;
            }
        }
        else if(seq == 2) {
            if (cs.getCookingLevel() < 20 && (client.bankContains(cs, "shrimp", 100) || client.hasItem(cs, "shrimp", 1))) {
                if (!client.hasItem(cs, "shrimp", 1)) {
                    client.withdraw(cs, "shrimp", 90);
                    return true;
                }
                cook(cs, "cooked_shrimp",client.countItem(cs,"shrimp")/6);
                return true;
            } else if (cs.getCookingLevel() < 20 && !client.bankContains(cs, "shrimp", 100)) {
                client.gather(cs, LOC_SHRIMP);
                return true;
            }
        }
        return false;
    }

    private static void cook(CharacterSchema cs, String fish,int amnt) {
        if(!client.posEqual(cs,LOC_WORKSHOP_COOKING)){
            client.actionMove(cs,LOC_WORKSHOP_COOKING);
            return;
        }
        client.craft(cs, fish, amnt);
        return;
    }


    private static void doWoodenStaff(CharacterSchema cs) {
        if(!client.hasItem(cs,"ash_wood",4)){
            if(!client.posEqual(cs,LOC_ASH)){
                client.actionMove(cs,LOC_ASH);
                return;
            }
            client.actionGathering(cs);
            return;
        }
        if(!cs.getWeaponSlot().equals("wooden_staff") && !client.hasItem(cs,"wooden_staff",1) && client.hasItem(cs,"wooden_stick",1)) {
            if(!client.posEqual(cs,LOC_WORKSHOP_WEAPON)){
                client.actionMove(cs,LOC_WORKSHOP_WEAPON);
                return;
            }
            if(!cs.getWeaponSlot().equals("")){
                client.unequip(cs,"weapon");
                return;
            }
            client.craft(cs, "wooden_staff", 1);
            return;
        }
        if(!cs.getWeaponSlot().equals("wooden_staff") && client.hasItem(cs,"wooden_staff",1)){
            client.equip(cs,"wooden_staff","weapon");
            return;
        }
        return;
    }


    private static void makeCharCheck() {
        switch (client.getMyCharacters().size()) {
            case 0:
                client.createCharacter(USERNAME_PREFIX+"1", AddCharacterSchema.SkinEnum.MEN1);
            case 1:
                client.createCharacter(USERNAME_PREFIX+"2", AddCharacterSchema.SkinEnum.MEN2);
            case 2:
                client.createCharacter(USERNAME_PREFIX+"3", AddCharacterSchema.SkinEnum.MEN3);
            case 3:
                client.createCharacter(USERNAME_PREFIX+"4", AddCharacterSchema.SkinEnum.WOMEN2);
            case 4:
                client.createCharacter(USERNAME_PREFIX+"5", AddCharacterSchema.SkinEnum.WOMEN3);
                break;
        }
    }
}
