package com.artifactmmo;

// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.api.*;
import org.openapitools.client.model.*;

import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.List;
import static com.artifactmmo.Data.*;

public class Client {
    static String BASE_PATH = "https://api.artifactsmmo.com";

    private final String token;

    public Client(String token){
        this.token = token;
    }

    public Client(String email, String password){
        this(generateToken(email,password));
    }

    public static String generateToken(String username, String password) {
        ApiClient defaultClient = getClient(username, password);

        TokenApi apiInstance = new TokenApi(defaultClient);
        try {
            TokenResponseSchema result = apiInstance.generateTokenTokenPost();
            return result.getToken();
        } catch (ApiException e) {
            System.err.println("Exception when calling TokenApi#generateTokenTokenPost");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
            return null;
        }
    }

    public void addAccount(String email, String password, String user) {
        ApiClient defaultClient = getClient();

        AccountsApi apiInstance = new AccountsApi(defaultClient);
        AddAccountSchema addAccountSchema = new AddAccountSchema();
        addAccountSchema.email(email).password(password).username(user);
        try {
            ResponseSchema result = apiInstance.createAccountAccountsCreatePost(addAccountSchema);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AccountsApi#createAccountAccountsCreatePost");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }

    public CharacterResponseSchema createCharacter(String characterName){
        return createCharacter(characterName,null);
    }

    public CharacterResponseSchema createCharacter(String characterName,AddCharacterSchema.SkinEnum skin) {
        ApiClient defaultClient = getClient();

        CharactersApi apiInstance = new CharactersApi(defaultClient);
        AddCharacterSchema addCharacterSchema = new AddCharacterSchema();
        addCharacterSchema.setName(characterName);
        if(skin!=null) {
            addCharacterSchema.setSkin(AddCharacterSchema.SkinEnum.WOMEN1);
        }
        try {
            return apiInstance.createCharacterCharactersCreatePost(addCharacterSchema);
        } catch (ApiException e) {
            System.err.println("Exception when calling CharactersApi#createCharacterCharactersCreatePost");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
            return null;
        }
    }

    public CharacterResponseSchema deleteCharacter(String characterName) {
        ApiClient defaultClient = getClient();

        CharactersApi apiInstance = new CharactersApi(defaultClient);
        DeleteCharacterSchema deleteCharacterSchema = new DeleteCharacterSchema();
        deleteCharacterSchema.setName(characterName);
        try {
            return apiInstance.deleteCharacterCharactersDeletePost(deleteCharacterSchema);
        } catch (ApiException e) {
            System.err.println("Exception when calling CharactersApi#deleteCharacterCharactersDeletePost");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
            return null;
        }
    }

    public CharacterResponseSchema getCharacter(String name) {
        ApiClient defaultClient = getClient();
        CharactersApi apiInstance = new CharactersApi(defaultClient);
        try {
            // Call the method with the required parameters
            CharacterResponseSchema result = apiInstance.getCharacterCharactersNameGet(name);
            return result;
        } catch (ApiException e) {
            System.err.println("Exception when calling CharactersApi#getAllCharactersCharactersGet");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
            return null;
        }
    }

    public List<CharacterSchema> getAllCharacters(String sort) {
        ApiClient defaultClient = getClient();
        CharactersApi apiInstance = new CharactersApi(defaultClient);
        try {
            // Call the method with the required parameters
            DataPageCharacterSchema result = apiInstance.getAllCharactersCharactersGet(sort, 1, 50);
            return result.getData();
        } catch (ApiException e) {
            System.err.println("Exception when calling CharactersApi#getAllCharactersCharactersGet");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public List<CharacterSchema> getAllCharacters(String sort, Integer page, Integer size) {
        ApiClient defaultClient = getClient();
        CharactersApi apiInstance = new CharactersApi(defaultClient);
        try {
            // Call the method with the required parameters
            DataPageCharacterSchema result = apiInstance.getAllCharactersCharactersGet(sort, page, size);
            return result.getData();
        } catch (ApiException e) {
            System.err.println("Exception when calling CharactersApi#getAllCharactersCharactersGet");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
            return Collections.emptyList();
        }
    }


    private ApiClient getClient() {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath(BASE_PATH);
        defaultClient.addDefaultHeader("Authorization", "Bearer " + token);
        return defaultClient;
    }

    private static ApiClient getClient(String username, String password) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath(BASE_PATH);
        // Set the HTTP basic authentication credentials to get token with.
        defaultClient.setUsername(username);
        defaultClient.setPassword(password);
        return defaultClient;
    }

    private MyCharactersApi getMyCharactersAPI(){
        ApiClient defaultClient = getClient();
        return new MyCharactersApi(defaultClient);
    }

    private MyAccountApi getMyAccountAPI(){
        ApiClient defaultClient = getClient();
        return new MyAccountApi(defaultClient);
    }

    private AccountsApi getAccountsAPI(){
        ApiClient defaultClient = getClient();
        return new AccountsApi(defaultClient);
    }
    private CharactersApi getCharactersAPI(){
        ApiClient defaultClient = getClient();
        return new CharactersApi(defaultClient);
    }
    private DefaultApi getDefaultAPI(){
        ApiClient defaultClient = getClient();
        return new DefaultApi(defaultClient);
    }
    private EventsApi getEventsAPI(){
        ApiClient defaultClient = getClient();
        return new EventsApi(defaultClient);
    }
    private GrandExchangeApi getGrandExchangeAPI(){
        ApiClient defaultClient = getClient();
        return new GrandExchangeApi(defaultClient);
    }

    private ItemsApi getItemsAPI(){
        ApiClient defaultClient = getClient();
        return new ItemsApi(defaultClient);
    }

    private MapsApi getMapsAPI(){
        ApiClient defaultClient = getClient();
        return new MapsApi(defaultClient);
    }

    private ResourcesApi getResourcesAPI(){
        ApiClient defaultClient = getClient();
        return new ResourcesApi(defaultClient);
    }
    private MonstersApi getMonstersAPI(){
        ApiClient defaultClient = getClient();
        return new MonstersApi(defaultClient);
    }

    public CharacterMovementResponseSchema actionMove(CharacterSchema charschema, DestinationSchema destination) {
        MyCharactersApi apiInstance = getMyCharactersAPI();
        try {
            return apiInstance.actionMoveMyNameActionMovePost(charschema.getName(), destination);
        } catch (ApiException e) {
            System.err.println("Exception when calling MyCharactersApi#moveCharacter");
            e.printStackTrace();
        }
        return null;
    }

    public SkillResponseSchema actionGathering(CharacterSchema charschema) {
        MyCharactersApi apiInstance = getMyCharactersAPI();
        try {
            return apiInstance.actionGatheringMyNameActionGatheringPost(charschema.getName());
        } catch (ApiException e) {
            System.err.println("Exception when calling MyCharactersApi#actionGathering");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<CharacterSchema> getMyCharacters(){
        MyCharactersApi apiInstance = getMyCharactersAPI();
        try {
            return apiInstance.getMyCharactersMyCharactersGetWithHttpInfo().getData().getData();
        } catch (ApiException e) {
            System.err.println("Exception when calling MyCharactersApi#getMyCharacters");
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    public CharacterMovementResponseSchema actionMove(CharacterSchema charschema, int x, int y) {
        DestinationSchema ds = new DestinationSchema();
        ds.setX(x);
        ds.setY(y);
        return actionMove(charschema,ds);
    }

    public CharacterFightResponseSchema attackAction(CharacterSchema charschema) {
        MyCharactersApi apiInstance = getMyCharactersAPI();
        try {
            return apiInstance.actionFightMyNameActionFightPost(charschema.getName());
        } catch (ApiException e) {
            System.err.println("Exception when calling attackAction");
            e.printStackTrace();
        }
        return null;
    }

    public boolean cooldownExpired(CharacterSchema cs){
        if(cs.getCooldownExpiration() == null){
            return true;
        }
        return cs.getCooldownExpiration().isBefore(OffsetDateTime.now());
    }

    public static boolean posEqual(CharacterSchema cs, DestinationSchema schema) {
        return cs.getX() == schema.getX() && cs.getY() == schema.getY();
    }

    public boolean hasItem(CharacterSchema cs, String item, int amount) {
        int counter = 0;
        assert cs.getInventory() != null;
        for(InventorySlot is: cs.getInventory()){
            if(is.getCode().equals(item)){
                counter+= is.getQuantity();
            }
        }
        return counter >= amount;
    }

    public int countItem(CharacterSchema cs, String item) {
        int counter = 0;
        assert cs.getInventory() != null;
        for(InventorySlot is: cs.getInventory()){
            if(is.getCode().equals(item)){
                counter+= is.getQuantity();
            }
        }
        return counter;
    }

    public EquipmentResponseSchema unequip(CharacterSchema cs, String slot) {
        MyCharactersApi apiInstance = getMyCharactersAPI();
        UnequipSchema us = new UnequipSchema();
        us.setSlot(UnequipSchema.SlotEnum.fromValue(slot));
        try {
            return apiInstance.actionUnequipItemMyNameActionUnequipPost(cs.getName(),us);
        } catch (ApiException e) {
            throw new RuntimeException(e);
        }
    }

    public ActionItemBankResponseSchema bank(CharacterSchema cs, String code, int quantity) {
        MyCharactersApi apiInstance = getMyCharactersAPI();
        SimpleItemSchema us = new SimpleItemSchema();
        us.setCode(code);
        us.setQuantity(quantity);
        try {
            return apiInstance.actionDepositBankMyNameActionBankDepositPost(cs.getName(),us);
        } catch (ApiException e) {
            throw new RuntimeException(e);
        }
    }

    public void bankAll(CharacterSchema cs){
        if(!posEqual(cs,LOC_BANK)){
            actionMove(cs,LOC_BANK);
            return;
        }
        assert cs.getInventory() != null;
        for(InventorySlot is: cs.getInventory()){
            if(!is.getCode().equals("")) {
                bank(cs, is.getCode(), is.getQuantity());
                try {//TODO: another way
                    Thread.sleep(80);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void bankAny(CharacterSchema cs){
        if(!posEqual(cs,LOC_BANK)){
            actionMove(cs,LOC_BANK);
            return;
        }
        assert cs.getInventory() != null;
        for(InventorySlot is: cs.getInventory()){
            if(!is.getCode().equals("")) {
                bank(cs, is.getCode(), is.getQuantity());
                return;
            }
        }
    }

    public List<SimpleItemSchema> getBank(CharacterSchema cs, String itemToSearch, Integer page, Integer size){
        if(page == null)page = 1;
        if(size==null)size=50;
        MyAccountApi maa = getMyAccountAPI();
        try {
            return maa.getBankItemsMyBankItemsGet(itemToSearch,page,size).getData();
        } catch (ApiException e) {
            System.out.println(itemToSearch + " "+page+" "+size);
            throw new RuntimeException(e);
        }
    }

    public boolean bankContains(CharacterSchema cs,String item, Integer minAmount){
        if(minAmount == null)minAmount=1;
        try {
            MyAccountApi maa = getMyAccountAPI();
            DataPageSimpleItemSchema dsis = maa.getBankItemsMyBankItemsGet(item,1,50);
            int totalItems = dsis.getTotal();
            int pages = (totalItems / 50) + (totalItems % 50 == 0 ? 0 : 1);//account for items not being a multiple of 50.
            for(int x = 0; x < pages;x++) {
                if(x!=0){//we already grabbed first page, only grab not first page.
                    dsis = maa.getBankItemsMyBankItemsGet(item,x+1,50);//pages start at index 1.
                }
                List<SimpleItemSchema> ites = dsis.getData();
                for (SimpleItemSchema sis : ites) {
                    if (sis.getCode().equals(item)) {
                        return sis.getQuantity() >= minAmount;
                    }
                }
            }
        }
        catch(Exception e){
        }
        return false;
    }

    public ActionItemBankResponseSchema withdrawBank(CharacterSchema cs, String item, Integer amount){
        MyCharactersApi maa = getMyCharactersAPI();
        SimpleItemSchema sis = new SimpleItemSchema();
        sis.setQuantity(amount !=null?amount:1);
        sis.setCode(item);
        try {
            return maa.actionWithdrawBankMyNameActionBankWithdrawPost(cs.getName(),sis);
        } catch (ApiException e) {
            throw new RuntimeException(e);
        }
    }

    public SkillResponseSchema craft(CharacterSchema cs, String item, int amount) {
        MyCharactersApi apiInstance = getMyCharactersAPI();
        CraftingSchema us = new CraftingSchema();
        us.setCode(item);
        us.setQuantity(amount > 0 ? amount : 1);
        try {
            return apiInstance.actionCraftingMyNameActionCraftingPost(cs.getName(),us);
        } catch (ApiException e) {
            throw new RuntimeException(e);
        }
    }

    public EquipmentResponseSchema equip(CharacterSchema cs, String item, String slot) {
        MyCharactersApi apiInstance = getMyCharactersAPI();
        EquipSchema us = new EquipSchema();
        us.setCode(item);
        us.setSlot(EquipSchema.SlotEnum.fromValue(slot));
        try {
            return apiInstance.actionEquipItemMyNameActionEquipPost(cs.getName(),us);
        } catch (ApiException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean makeAndEquip(CharacterSchema cs, DestinationSchema craftSpot, String item, String inSlot, String slot, SimpleItemSchema[] reagents){
        if(inSlot.equals(item)){//we got what we want on.
            return false;
        }
        if(!inSlot.equals("")){//we have something equipped already in that slot
            unequip(cs,slot);
            return true;
        }
        if(hasItem(cs,item,1)){//we have the item, but not equipped
            equip(cs,item,slot);
            return true;
        }
        if(bankContains(cs,item,1)){//the item exists in our bank
            withdraw(cs,item,1);
            return true;
        }
        //we need to make the item
        for(SimpleItemSchema reag : reagents){
            if(hasItem(cs,reag.getCode(),reag.getQuantity())){//we have the reag
                continue;
            }
            else if(bankContains(cs,reag.getCode(),reag.getQuantity())){//the reag exists in our bank
                withdraw(cs,reag.getCode(),reag.getQuantity());
                return true;
            }
            else{
                //we need to obtain it somehow?
                System.out.println(cs.getName()+" Help i need something!"+reag.getCode());
            }
        }
        //well me must have everything to create by now.
        if(!posEqual(cs,craftSpot)){
            actionMove(cs,craftSpot);
            return true;
        }
        craft(cs,item,1);
        return true;
    }

    public boolean make(CharacterSchema cs, DestinationSchema craftSpot, String item, SimpleItemSchema[] reagents, boolean stopWhenHave){
        return obtain(cs,craftSpot, item, reagents,stopWhenHave,false,true);
    }

    private  boolean obtain(CharacterSchema cs,DestinationSchema craftSpot, String item, SimpleItemSchema[] reagents,boolean stopWhenHave,boolean grabFromBank,boolean craftFromBank){
        if(hasItem(cs,item,1) && stopWhenHave){//we have the item
            return false;
        }
        if(grabFromBank && bankContains(cs,item,1)){//the item exists in our bank,lets grab
            withdraw(cs,item,1);
            return true;
        }
        //we need to make the item
        for(SimpleItemSchema reag : reagents){
            if(hasItem(cs,reag.getCode(),reag.getQuantity())){//we have the reag
                continue;
            }
            else if(craftFromBank && bankContains(cs,reag.getCode(),reag.getQuantity())){//the reag exists in our bank
                withdraw(cs,reag.getCode(),reag.getQuantity());
                return true;
            }
            else{
                return false;//we dont have the shit to make
            }
        }
        //well me must have everything to create by now.
        if(!posEqual(cs,craftSpot)){
            actionMove(cs,craftSpot);
            return true;
        }
        craft(cs,item,1);
        return true;
    }

    public void withdraw(CharacterSchema cs, String item, int i) {
        if(!posEqual(cs,LOC_BANK)){
            actionMove(cs,LOC_BANK);
            return;
        }
        withdrawBank(cs,item,i);
        return;
    }

    public void attack(CharacterSchema cs, DestinationSchema loc) {
        if(!posEqual(cs,loc)){
            actionMove(cs,loc);
            return;
        }
        attackAction(cs);
    }

    public SkillResponseSchema gather(CharacterSchema cs, DestinationSchema loc) {
        if(!posEqual(cs,loc)){
            actionMove(cs,loc);
            return null;
        }
        return actionGathering(cs);
    }

    public int countInventory(CharacterSchema character) {
        int count = 0;
        assert character.getInventory() != null;
        for(InventorySlot is : character.getInventory()){
            if(is.getCode().equals(""))continue;
            count+=is.getQuantity();
        }
        return count;
    }

    public boolean bankOrInventoryContains(CharacterSchema cs, String item, Integer minAmount) {
        if(minAmount == null)minAmount=1;
        int amnt = 0;
        try {
            MyAccountApi maa = getMyAccountAPI();
            DataPageSimpleItemSchema dsis = maa.getBankItemsMyBankItemsGet(item,1,50);
            int totalItems = dsis.getTotal();
            int pages = (totalItems / 50) + (totalItems % 50 == 0 ? 0 : 1);//account for items not being a multiple of 50.
            for(int x = 0; x < pages;x++) {
                if(x!=0){//we already grabbed first page, only grab not first page.
                    dsis = maa.getBankItemsMyBankItemsGet(item,x+1,50);//pages start at index 1.
                }
                List<SimpleItemSchema> ites = dsis.getData();
                for (SimpleItemSchema sis : ites) {
                    if (sis.getCode().equals(item)) {
                        amnt +=sis.getQuantity();
                    }
                }
            }
        }
        catch(Exception e){
        }
        for(InventorySlot is : cs.getInventory()){
            if(is.getCode().equals(""))continue;
            if (is.getCode().equals(item)) {
                amnt += is.getQuantity();
            }
        }

        return amnt >= minAmount;
    }

    public boolean invContains(CharacterSchema cs, String item, int quantity) {
        int amnt = 0;
        for(InventorySlot is : cs.getInventory()){
            if(is.getCode().equals(""))continue;
            if (is.getCode().equals(item)) {
                amnt += is.getQuantity();
            }
        }
        return amnt >= quantity;
    }
}
