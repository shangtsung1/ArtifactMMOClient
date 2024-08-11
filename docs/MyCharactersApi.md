# MyCharactersApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**actionAcceptNewTaskMyNameActionTaskNewPost**](MyCharactersApi.md#actionAcceptNewTaskMyNameActionTaskNewPost) | **POST** /my/{name}/action/task/new | Action Accept New Task |
| [**actionCompleteTaskMyNameActionTaskCompletePost**](MyCharactersApi.md#actionCompleteTaskMyNameActionTaskCompletePost) | **POST** /my/{name}/action/task/complete | Action Complete Task |
| [**actionCraftingMyNameActionCraftingPost**](MyCharactersApi.md#actionCraftingMyNameActionCraftingPost) | **POST** /my/{name}/action/crafting | Action Crafting |
| [**actionDeleteItemMyNameActionDeletePost**](MyCharactersApi.md#actionDeleteItemMyNameActionDeletePost) | **POST** /my/{name}/action/delete | Action Delete Item |
| [**actionDepositBankGoldMyNameActionBankDepositGoldPost**](MyCharactersApi.md#actionDepositBankGoldMyNameActionBankDepositGoldPost) | **POST** /my/{name}/action/bank/deposit/gold | Action Deposit Bank Gold |
| [**actionDepositBankMyNameActionBankDepositPost**](MyCharactersApi.md#actionDepositBankMyNameActionBankDepositPost) | **POST** /my/{name}/action/bank/deposit | Action Deposit Bank |
| [**actionEquipItemMyNameActionEquipPost**](MyCharactersApi.md#actionEquipItemMyNameActionEquipPost) | **POST** /my/{name}/action/equip | Action Equip Item |
| [**actionFightMyNameActionFightPost**](MyCharactersApi.md#actionFightMyNameActionFightPost) | **POST** /my/{name}/action/fight | Action Fight |
| [**actionGatheringMyNameActionGatheringPost**](MyCharactersApi.md#actionGatheringMyNameActionGatheringPost) | **POST** /my/{name}/action/gathering | Action Gathering |
| [**actionGeBuyItemMyNameActionGeBuyPost**](MyCharactersApi.md#actionGeBuyItemMyNameActionGeBuyPost) | **POST** /my/{name}/action/ge/buy | Action Ge Buy Item |
| [**actionGeSellItemMyNameActionGeSellPost**](MyCharactersApi.md#actionGeSellItemMyNameActionGeSellPost) | **POST** /my/{name}/action/ge/sell | Action Ge Sell Item |
| [**actionMoveMyNameActionMovePost**](MyCharactersApi.md#actionMoveMyNameActionMovePost) | **POST** /my/{name}/action/move | Action Move |
| [**actionRecyclingMyNameActionRecyclingPost**](MyCharactersApi.md#actionRecyclingMyNameActionRecyclingPost) | **POST** /my/{name}/action/recycling | Action Recycling |
| [**actionTaskExchangeMyNameActionTaskExchangePost**](MyCharactersApi.md#actionTaskExchangeMyNameActionTaskExchangePost) | **POST** /my/{name}/action/task/exchange | Action Task Exchange |
| [**actionUnequipItemMyNameActionUnequipPost**](MyCharactersApi.md#actionUnequipItemMyNameActionUnequipPost) | **POST** /my/{name}/action/unequip | Action Unequip Item |
| [**actionWithdrawBankGoldMyNameActionBankWithdrawGoldPost**](MyCharactersApi.md#actionWithdrawBankGoldMyNameActionBankWithdrawGoldPost) | **POST** /my/{name}/action/bank/withdraw/gold | Action Withdraw Bank Gold |
| [**actionWithdrawBankMyNameActionBankWithdrawPost**](MyCharactersApi.md#actionWithdrawBankMyNameActionBankWithdrawPost) | **POST** /my/{name}/action/bank/withdraw | Action Withdraw Bank |
| [**getAllCharactersLogsMyLogsGet**](MyCharactersApi.md#getAllCharactersLogsMyLogsGet) | **GET** /my/logs | Get All Characters Logs |
| [**getMyCharactersMyCharactersGet**](MyCharactersApi.md#getMyCharactersMyCharactersGet) | **GET** /my/characters | Get My Characters |


<a id="actionAcceptNewTaskMyNameActionTaskNewPost"></a>
# **actionAcceptNewTaskMyNameActionTaskNewPost**
> TaskResponseSchema actionAcceptNewTaskMyNameActionTaskNewPost(name)

Action Accept New Task

Accepting a new task.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.MyCharactersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure HTTP bearer authorization: JWTBearer
    HttpBearerAuth JWTBearer = (HttpBearerAuth) defaultClient.getAuthentication("JWTBearer");
    JWTBearer.setBearerToken("BEARER TOKEN");

    MyCharactersApi apiInstance = new MyCharactersApi(defaultClient);
    String name = "name_example"; // String | Name of your character.
    try {
      TaskResponseSchema result = apiInstance.actionAcceptNewTaskMyNameActionTaskNewPost(name);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MyCharactersApi#actionAcceptNewTaskMyNameActionTaskNewPost");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **name** | **String**| Name of your character. | |

### Return type

[**TaskResponseSchema**](TaskResponseSchema.md)

### Authorization

[JWTBearer](../README.md#JWTBearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | New task successfully accepted. |  -  |
| **498** | Character not found. |  -  |
| **499** | Character in cooldown. |  -  |
| **486** | An action is already in progress by your character. |  -  |
| **598** | Tasks Master not found on this map. |  -  |
| **489** | Character already has a task. |  -  |

<a id="actionCompleteTaskMyNameActionTaskCompletePost"></a>
# **actionCompleteTaskMyNameActionTaskCompletePost**
> TaskRewardResponseSchema actionCompleteTaskMyNameActionTaskCompletePost(name)

Action Complete Task

Complete a task.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.MyCharactersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure HTTP bearer authorization: JWTBearer
    HttpBearerAuth JWTBearer = (HttpBearerAuth) defaultClient.getAuthentication("JWTBearer");
    JWTBearer.setBearerToken("BEARER TOKEN");

    MyCharactersApi apiInstance = new MyCharactersApi(defaultClient);
    String name = "name_example"; // String | Name of your character.
    try {
      TaskRewardResponseSchema result = apiInstance.actionCompleteTaskMyNameActionTaskCompletePost(name);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MyCharactersApi#actionCompleteTaskMyNameActionTaskCompletePost");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **name** | **String**| Name of your character. | |

### Return type

[**TaskRewardResponseSchema**](TaskRewardResponseSchema.md)

### Authorization

[JWTBearer](../README.md#JWTBearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The task has been successfully completed. |  -  |
| **498** | Character not found. |  -  |
| **499** | Character in cooldown. |  -  |
| **486** | An action is already in progress by your character. |  -  |
| **598** | Tasks Master not found on this map. |  -  |
| **488** | Character has not completed the task. |  -  |
| **487** | Character has no task. |  -  |
| **497** | Character inventory is full. |  -  |

<a id="actionCraftingMyNameActionCraftingPost"></a>
# **actionCraftingMyNameActionCraftingPost**
> SkillResponseSchema actionCraftingMyNameActionCraftingPost(name, craftingSchema)

Action Crafting

Crafting an item. The character must be on a map with a workshop.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.MyCharactersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure HTTP bearer authorization: JWTBearer
    HttpBearerAuth JWTBearer = (HttpBearerAuth) defaultClient.getAuthentication("JWTBearer");
    JWTBearer.setBearerToken("BEARER TOKEN");

    MyCharactersApi apiInstance = new MyCharactersApi(defaultClient);
    String name = "name_example"; // String | Name of your character.
    CraftingSchema craftingSchema = new CraftingSchema(); // CraftingSchema | 
    try {
      SkillResponseSchema result = apiInstance.actionCraftingMyNameActionCraftingPost(name, craftingSchema);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MyCharactersApi#actionCraftingMyNameActionCraftingPost");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **name** | **String**| Name of your character. | |
| **craftingSchema** | [**CraftingSchema**](CraftingSchema.md)|  | |

### Return type

[**SkillResponseSchema**](SkillResponseSchema.md)

### Authorization

[JWTBearer](../README.md#JWTBearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The item was successfully crafted. |  -  |
| **404** | Craft not found. |  -  |
| **598** | Workshop not found on this map. |  -  |
| **498** | Character not found. |  -  |
| **497** | Character inventory is full. |  -  |
| **499** | Character in cooldown. |  -  |
| **486** | An action is already in progress by your character. |  -  |
| **493** | Not skill level required. |  -  |
| **478** | Missing item or insufficient quantity in your inventory. |  -  |

<a id="actionDeleteItemMyNameActionDeletePost"></a>
# **actionDeleteItemMyNameActionDeletePost**
> DeleteItemResponseSchema actionDeleteItemMyNameActionDeletePost(name, simpleItemSchema)

Action Delete Item

Delete an item from your character&#39;s inventory.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.MyCharactersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure HTTP bearer authorization: JWTBearer
    HttpBearerAuth JWTBearer = (HttpBearerAuth) defaultClient.getAuthentication("JWTBearer");
    JWTBearer.setBearerToken("BEARER TOKEN");

    MyCharactersApi apiInstance = new MyCharactersApi(defaultClient);
    String name = "name_example"; // String | Name of your character.
    SimpleItemSchema simpleItemSchema = new SimpleItemSchema(); // SimpleItemSchema | 
    try {
      DeleteItemResponseSchema result = apiInstance.actionDeleteItemMyNameActionDeletePost(name, simpleItemSchema);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MyCharactersApi#actionDeleteItemMyNameActionDeletePost");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **name** | **String**| Name of your character. | |
| **simpleItemSchema** | [**SimpleItemSchema**](SimpleItemSchema.md)|  | |

### Return type

[**DeleteItemResponseSchema**](DeleteItemResponseSchema.md)

### Authorization

[JWTBearer](../README.md#JWTBearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Item successfully deleted from your character. |  -  |
| **498** | Character not found. |  -  |
| **499** | Character in cooldown. |  -  |
| **486** | An action is already in progress by your character. |  -  |
| **478** | Missing item or insufficient quantity in your inventory. |  -  |

<a id="actionDepositBankGoldMyNameActionBankDepositGoldPost"></a>
# **actionDepositBankGoldMyNameActionBankDepositGoldPost**
> GoldResponseSchema actionDepositBankGoldMyNameActionBankDepositGoldPost(name, depositWithdrawGoldSchema)

Action Deposit Bank Gold

Deposit golds in a bank on the character&#39;s map.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.MyCharactersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure HTTP bearer authorization: JWTBearer
    HttpBearerAuth JWTBearer = (HttpBearerAuth) defaultClient.getAuthentication("JWTBearer");
    JWTBearer.setBearerToken("BEARER TOKEN");

    MyCharactersApi apiInstance = new MyCharactersApi(defaultClient);
    String name = "name_example"; // String | Name of your character.
    DepositWithdrawGoldSchema depositWithdrawGoldSchema = new DepositWithdrawGoldSchema(); // DepositWithdrawGoldSchema | 
    try {
      GoldResponseSchema result = apiInstance.actionDepositBankGoldMyNameActionBankDepositGoldPost(name, depositWithdrawGoldSchema);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MyCharactersApi#actionDepositBankGoldMyNameActionBankDepositGoldPost");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **name** | **String**| Name of your character. | |
| **depositWithdrawGoldSchema** | [**DepositWithdrawGoldSchema**](DepositWithdrawGoldSchema.md)|  | |

### Return type

[**GoldResponseSchema**](GoldResponseSchema.md)

### Authorization

[JWTBearer](../README.md#JWTBearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Golds successfully deposited in your bank. |  -  |
| **598** | Bank not found on this map. |  -  |
| **492** | Insufficient golds on your character. |  -  |
| **498** | Character not found. |  -  |
| **499** | Character in cooldown. |  -  |
| **461** | A transaction is already in progress with this item/your golds in your bank. |  -  |
| **486** | An action is already in progress by your character. |  -  |

<a id="actionDepositBankMyNameActionBankDepositPost"></a>
# **actionDepositBankMyNameActionBankDepositPost**
> ActionItemBankResponseSchema actionDepositBankMyNameActionBankDepositPost(name, simpleItemSchema)

Action Deposit Bank

Deposit an item in a bank on the character&#39;s map.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.MyCharactersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure HTTP bearer authorization: JWTBearer
    HttpBearerAuth JWTBearer = (HttpBearerAuth) defaultClient.getAuthentication("JWTBearer");
    JWTBearer.setBearerToken("BEARER TOKEN");

    MyCharactersApi apiInstance = new MyCharactersApi(defaultClient);
    String name = "name_example"; // String | Name of your character.
    SimpleItemSchema simpleItemSchema = new SimpleItemSchema(); // SimpleItemSchema | 
    try {
      ActionItemBankResponseSchema result = apiInstance.actionDepositBankMyNameActionBankDepositPost(name, simpleItemSchema);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MyCharactersApi#actionDepositBankMyNameActionBankDepositPost");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **name** | **String**| Name of your character. | |
| **simpleItemSchema** | [**SimpleItemSchema**](SimpleItemSchema.md)|  | |

### Return type

[**ActionItemBankResponseSchema**](ActionItemBankResponseSchema.md)

### Authorization

[JWTBearer](../README.md#JWTBearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Item successfully deposited in your bank. |  -  |
| **598** | Bank not found on this map. |  -  |
| **404** | Item not found. |  -  |
| **461** | A transaction is already in progress with this item/your golds in your bank. |  -  |
| **498** | Character not found. |  -  |
| **499** | Character in cooldown. |  -  |
| **486** | An action is already in progress by your character. |  -  |
| **478** | Missing item or insufficient quantity in your inventory. |  -  |

<a id="actionEquipItemMyNameActionEquipPost"></a>
# **actionEquipItemMyNameActionEquipPost**
> EquipmentResponseSchema actionEquipItemMyNameActionEquipPost(name, equipSchema)

Action Equip Item

Equip an item on your character.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.MyCharactersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure HTTP bearer authorization: JWTBearer
    HttpBearerAuth JWTBearer = (HttpBearerAuth) defaultClient.getAuthentication("JWTBearer");
    JWTBearer.setBearerToken("BEARER TOKEN");

    MyCharactersApi apiInstance = new MyCharactersApi(defaultClient);
    String name = "name_example"; // String | Name of your character.
    EquipSchema equipSchema = new EquipSchema(); // EquipSchema | 
    try {
      EquipmentResponseSchema result = apiInstance.actionEquipItemMyNameActionEquipPost(name, equipSchema);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MyCharactersApi#actionEquipItemMyNameActionEquipPost");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **name** | **String**| Name of your character. | |
| **equipSchema** | [**EquipSchema**](EquipSchema.md)|  | |

### Return type

[**EquipmentResponseSchema**](EquipmentResponseSchema.md)

### Authorization

[JWTBearer](../README.md#JWTBearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The item has been successfully equipped on your character. |  -  |
| **404** | Item not found. |  -  |
| **498** | Character not found. |  -  |
| **499** | Character in cooldown. |  -  |
| **486** | An action is already in progress by your character. |  -  |
| **478** | Missing item or insufficient quantity in your inventory. |  -  |
| **496** | Character level is insufficient. |  -  |
| **491** | Slot is not empty. |  -  |
| **485** | This item is already equipped. |  -  |

<a id="actionFightMyNameActionFightPost"></a>
# **actionFightMyNameActionFightPost**
> CharacterFightResponseSchema actionFightMyNameActionFightPost(name)

Action Fight

Start a fight against a monster on the character&#39;s map.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.MyCharactersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure HTTP bearer authorization: JWTBearer
    HttpBearerAuth JWTBearer = (HttpBearerAuth) defaultClient.getAuthentication("JWTBearer");
    JWTBearer.setBearerToken("BEARER TOKEN");

    MyCharactersApi apiInstance = new MyCharactersApi(defaultClient);
    String name = "name_example"; // String | Name of your character.
    try {
      CharacterFightResponseSchema result = apiInstance.actionFightMyNameActionFightPost(name);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MyCharactersApi#actionFightMyNameActionFightPost");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **name** | **String**| Name of your character. | |

### Return type

[**CharacterFightResponseSchema**](CharacterFightResponseSchema.md)

### Authorization

[JWTBearer](../README.md#JWTBearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The fight ended successfully. |  -  |
| **498** | Character not found. |  -  |
| **499** | Character in cooldown. |  -  |
| **598** | Monster not found on this map. |  -  |
| **486** | An action is already in progress by your character. |  -  |
| **497** | Character inventory is full. |  -  |

<a id="actionGatheringMyNameActionGatheringPost"></a>
# **actionGatheringMyNameActionGatheringPost**
> SkillResponseSchema actionGatheringMyNameActionGatheringPost(name)

Action Gathering

Harvest a resource on the character&#39;s map.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.MyCharactersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure HTTP bearer authorization: JWTBearer
    HttpBearerAuth JWTBearer = (HttpBearerAuth) defaultClient.getAuthentication("JWTBearer");
    JWTBearer.setBearerToken("BEARER TOKEN");

    MyCharactersApi apiInstance = new MyCharactersApi(defaultClient);
    String name = "name_example"; // String | Name of your character.
    try {
      SkillResponseSchema result = apiInstance.actionGatheringMyNameActionGatheringPost(name);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MyCharactersApi#actionGatheringMyNameActionGatheringPost");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **name** | **String**| Name of your character. | |

### Return type

[**SkillResponseSchema**](SkillResponseSchema.md)

### Authorization

[JWTBearer](../README.md#JWTBearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The resource has been successfully gathered. |  -  |
| **498** | Character not found. |  -  |
| **499** | Character in cooldown. |  -  |
| **598** | Resource not found on this map. |  -  |
| **486** | An action is already in progress by your character. |  -  |
| **493** | Not skill level required. |  -  |
| **497** | Character inventory is full. |  -  |

<a id="actionGeBuyItemMyNameActionGeBuyPost"></a>
# **actionGeBuyItemMyNameActionGeBuyPost**
> GETransactionResponseSchema actionGeBuyItemMyNameActionGeBuyPost(name, geTransactionItemSchema)

Action Ge Buy Item

Buy an item at the Grand Exchange on the character&#39;s map.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.MyCharactersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure HTTP bearer authorization: JWTBearer
    HttpBearerAuth JWTBearer = (HttpBearerAuth) defaultClient.getAuthentication("JWTBearer");
    JWTBearer.setBearerToken("BEARER TOKEN");

    MyCharactersApi apiInstance = new MyCharactersApi(defaultClient);
    String name = "name_example"; // String | Name of your character.
    GETransactionItemSchema geTransactionItemSchema = new GETransactionItemSchema(); // GETransactionItemSchema | 
    try {
      GETransactionResponseSchema result = apiInstance.actionGeBuyItemMyNameActionGeBuyPost(name, geTransactionItemSchema);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MyCharactersApi#actionGeBuyItemMyNameActionGeBuyPost");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **name** | **String**| Name of your character. | |
| **geTransactionItemSchema** | [**GETransactionItemSchema**](GETransactionItemSchema.md)|  | |

### Return type

[**GETransactionResponseSchema**](GETransactionResponseSchema.md)

### Authorization

[JWTBearer](../README.md#JWTBearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Item successfully buy from the Grand Exchange. |  -  |
| **598** | Grand Exchange not found on this map. |  -  |
| **498** | Character not found. |  -  |
| **497** | Character inventory is full. |  -  |
| **499** | Character in cooldown. |  -  |
| **483** | A transaction is already in progress on this item by a another character. |  -  |
| **486** | An action is already in progress by your character. |  -  |
| **492** | Insufficient golds on your character. |  -  |
| **480** | No stock for this item. |  -  |
| **482** | No item at this price. |  -  |

<a id="actionGeSellItemMyNameActionGeSellPost"></a>
# **actionGeSellItemMyNameActionGeSellPost**
> GETransactionResponseSchema actionGeSellItemMyNameActionGeSellPost(name, geTransactionItemSchema)

Action Ge Sell Item

Sell an item at the Grand Exchange on the character&#39;s map.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.MyCharactersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure HTTP bearer authorization: JWTBearer
    HttpBearerAuth JWTBearer = (HttpBearerAuth) defaultClient.getAuthentication("JWTBearer");
    JWTBearer.setBearerToken("BEARER TOKEN");

    MyCharactersApi apiInstance = new MyCharactersApi(defaultClient);
    String name = "name_example"; // String | Name of your character.
    GETransactionItemSchema geTransactionItemSchema = new GETransactionItemSchema(); // GETransactionItemSchema | 
    try {
      GETransactionResponseSchema result = apiInstance.actionGeSellItemMyNameActionGeSellPost(name, geTransactionItemSchema);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MyCharactersApi#actionGeSellItemMyNameActionGeSellPost");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **name** | **String**| Name of your character. | |
| **geTransactionItemSchema** | [**GETransactionItemSchema**](GETransactionItemSchema.md)|  | |

### Return type

[**GETransactionResponseSchema**](GETransactionResponseSchema.md)

### Authorization

[JWTBearer](../README.md#JWTBearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Item successfully sell at the Grand Exchange. |  -  |
| **498** | Character not found. |  -  |
| **499** | Character in cooldown. |  -  |
| **404** | Item not found. |  -  |
| **483** | A transaction is already in progress on this item by a another character. |  -  |
| **486** | An action is already in progress by your character. |  -  |
| **478** | Missing item or insufficient quantity in your inventory. |  -  |
| **482** | No item at this price. |  -  |
| **598** | Grand Exchange not found on this map. |  -  |

<a id="actionMoveMyNameActionMovePost"></a>
# **actionMoveMyNameActionMovePost**
> CharacterMovementResponseSchema actionMoveMyNameActionMovePost(name, destinationSchema)

Action Move

Moves a character on the map using the map&#39;s X and Y position.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.MyCharactersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure HTTP bearer authorization: JWTBearer
    HttpBearerAuth JWTBearer = (HttpBearerAuth) defaultClient.getAuthentication("JWTBearer");
    JWTBearer.setBearerToken("BEARER TOKEN");

    MyCharactersApi apiInstance = new MyCharactersApi(defaultClient);
    String name = "name_example"; // String | Name of your character.
    DestinationSchema destinationSchema = new DestinationSchema(); // DestinationSchema | 
    try {
      CharacterMovementResponseSchema result = apiInstance.actionMoveMyNameActionMovePost(name, destinationSchema);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MyCharactersApi#actionMoveMyNameActionMovePost");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **name** | **String**| Name of your character. | |
| **destinationSchema** | [**DestinationSchema**](DestinationSchema.md)|  | |

### Return type

[**CharacterMovementResponseSchema**](CharacterMovementResponseSchema.md)

### Authorization

[JWTBearer](../README.md#JWTBearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The character has moved successfully. |  -  |
| **498** | Character not found. |  -  |
| **499** | Character in cooldown. |  -  |
| **490** | Character already at destination. |  -  |
| **404** | Map not found. |  -  |
| **486** | An action is already in progress by your character. |  -  |

<a id="actionRecyclingMyNameActionRecyclingPost"></a>
# **actionRecyclingMyNameActionRecyclingPost**
> RecyclingResponseSchema actionRecyclingMyNameActionRecyclingPost(name, recyclingSchema)

Action Recycling

Recyling an item. The character must be on a map with a workshop (only for equipments and weapons).

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.MyCharactersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure HTTP bearer authorization: JWTBearer
    HttpBearerAuth JWTBearer = (HttpBearerAuth) defaultClient.getAuthentication("JWTBearer");
    JWTBearer.setBearerToken("BEARER TOKEN");

    MyCharactersApi apiInstance = new MyCharactersApi(defaultClient);
    String name = "name_example"; // String | Name of your character.
    RecyclingSchema recyclingSchema = new RecyclingSchema(); // RecyclingSchema | 
    try {
      RecyclingResponseSchema result = apiInstance.actionRecyclingMyNameActionRecyclingPost(name, recyclingSchema);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MyCharactersApi#actionRecyclingMyNameActionRecyclingPost");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **name** | **String**| Name of your character. | |
| **recyclingSchema** | [**RecyclingSchema**](RecyclingSchema.md)|  | |

### Return type

[**RecyclingResponseSchema**](RecyclingResponseSchema.md)

### Authorization

[JWTBearer](../README.md#JWTBearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The items were successfully recycled. |  -  |
| **404** | Item not found. |  -  |
| **598** | Workshop not found on this map. |  -  |
| **498** | Character not found. |  -  |
| **497** | Character inventory is full. |  -  |
| **499** | Character in cooldown. |  -  |
| **486** | An action is already in progress by your character. |  -  |
| **493** | Not skill level required. |  -  |
| **478** | Missing item or insufficient quantity in your inventory. |  -  |
| **473** | This item cannot be recycled. |  -  |

<a id="actionTaskExchangeMyNameActionTaskExchangePost"></a>
# **actionTaskExchangeMyNameActionTaskExchangePost**
> TaskRewardResponseSchema actionTaskExchangeMyNameActionTaskExchangePost(name)

Action Task Exchange

Exchange 3 tasks coins for a random reward. Rewards are exclusive resources for crafting  items.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.MyCharactersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure HTTP bearer authorization: JWTBearer
    HttpBearerAuth JWTBearer = (HttpBearerAuth) defaultClient.getAuthentication("JWTBearer");
    JWTBearer.setBearerToken("BEARER TOKEN");

    MyCharactersApi apiInstance = new MyCharactersApi(defaultClient);
    String name = "name_example"; // String | Name of your character.
    try {
      TaskRewardResponseSchema result = apiInstance.actionTaskExchangeMyNameActionTaskExchangePost(name);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MyCharactersApi#actionTaskExchangeMyNameActionTaskExchangePost");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **name** | **String**| Name of your character. | |

### Return type

[**TaskRewardResponseSchema**](TaskRewardResponseSchema.md)

### Authorization

[JWTBearer](../README.md#JWTBearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The tasks coins have been successfully exchanged. |  -  |
| **498** | Character not found. |  -  |
| **499** | Character in cooldown. |  -  |
| **486** | An action is already in progress by your character. |  -  |
| **598** | Tasks Master not found on this map. |  -  |
| **478** | Missing item or insufficient quantity in your inventory. |  -  |
| **497** | Character inventory is full. |  -  |

<a id="actionUnequipItemMyNameActionUnequipPost"></a>
# **actionUnequipItemMyNameActionUnequipPost**
> EquipmentResponseSchema actionUnequipItemMyNameActionUnequipPost(name, unequipSchema)

Action Unequip Item

Unequip an item on your character.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.MyCharactersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure HTTP bearer authorization: JWTBearer
    HttpBearerAuth JWTBearer = (HttpBearerAuth) defaultClient.getAuthentication("JWTBearer");
    JWTBearer.setBearerToken("BEARER TOKEN");

    MyCharactersApi apiInstance = new MyCharactersApi(defaultClient);
    String name = "name_example"; // String | Name of your character.
    UnequipSchema unequipSchema = new UnequipSchema(); // UnequipSchema | 
    try {
      EquipmentResponseSchema result = apiInstance.actionUnequipItemMyNameActionUnequipPost(name, unequipSchema);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MyCharactersApi#actionUnequipItemMyNameActionUnequipPost");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **name** | **String**| Name of your character. | |
| **unequipSchema** | [**UnequipSchema**](UnequipSchema.md)|  | |

### Return type

[**EquipmentResponseSchema**](EquipmentResponseSchema.md)

### Authorization

[JWTBearer](../README.md#JWTBearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The item has been successfully unequipped and added in his inventory. |  -  |
| **404** | Item not found. |  -  |
| **498** | Character not found. |  -  |
| **499** | Character in cooldown. |  -  |
| **486** | An action is already in progress by your character. |  -  |
| **491** | Slot is empty. |  -  |
| **497** | Character inventory is full. |  -  |

<a id="actionWithdrawBankGoldMyNameActionBankWithdrawGoldPost"></a>
# **actionWithdrawBankGoldMyNameActionBankWithdrawGoldPost**
> GoldResponseSchema actionWithdrawBankGoldMyNameActionBankWithdrawGoldPost(name, depositWithdrawGoldSchema)

Action Withdraw Bank Gold

Withdraw gold from your bank.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.MyCharactersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure HTTP bearer authorization: JWTBearer
    HttpBearerAuth JWTBearer = (HttpBearerAuth) defaultClient.getAuthentication("JWTBearer");
    JWTBearer.setBearerToken("BEARER TOKEN");

    MyCharactersApi apiInstance = new MyCharactersApi(defaultClient);
    String name = "name_example"; // String | Name of your character.
    DepositWithdrawGoldSchema depositWithdrawGoldSchema = new DepositWithdrawGoldSchema(); // DepositWithdrawGoldSchema | 
    try {
      GoldResponseSchema result = apiInstance.actionWithdrawBankGoldMyNameActionBankWithdrawGoldPost(name, depositWithdrawGoldSchema);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MyCharactersApi#actionWithdrawBankGoldMyNameActionBankWithdrawGoldPost");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **name** | **String**| Name of your character. | |
| **depositWithdrawGoldSchema** | [**DepositWithdrawGoldSchema**](DepositWithdrawGoldSchema.md)|  | |

### Return type

[**GoldResponseSchema**](GoldResponseSchema.md)

### Authorization

[JWTBearer](../README.md#JWTBearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Golds successfully withdraw from your bank. |  -  |
| **498** | Character not found. |  -  |
| **499** | Character in cooldown. |  -  |
| **461** | A transaction is already in progress with this item/your golds in your bank. |  -  |
| **486** | An action is already in progress by your character. |  -  |
| **598** | Bank not found on this map. |  -  |
| **460** | Insufficient golds in your bank. |  -  |

<a id="actionWithdrawBankMyNameActionBankWithdrawPost"></a>
# **actionWithdrawBankMyNameActionBankWithdrawPost**
> ActionItemBankResponseSchema actionWithdrawBankMyNameActionBankWithdrawPost(name, simpleItemSchema)

Action Withdraw Bank

Take an item from your bank and put it in the character&#39;s inventory.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.MyCharactersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure HTTP bearer authorization: JWTBearer
    HttpBearerAuth JWTBearer = (HttpBearerAuth) defaultClient.getAuthentication("JWTBearer");
    JWTBearer.setBearerToken("BEARER TOKEN");

    MyCharactersApi apiInstance = new MyCharactersApi(defaultClient);
    String name = "name_example"; // String | Name of your character.
    SimpleItemSchema simpleItemSchema = new SimpleItemSchema(); // SimpleItemSchema | 
    try {
      ActionItemBankResponseSchema result = apiInstance.actionWithdrawBankMyNameActionBankWithdrawPost(name, simpleItemSchema);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MyCharactersApi#actionWithdrawBankMyNameActionBankWithdrawPost");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **name** | **String**| Name of your character. | |
| **simpleItemSchema** | [**SimpleItemSchema**](SimpleItemSchema.md)|  | |

### Return type

[**ActionItemBankResponseSchema**](ActionItemBankResponseSchema.md)

### Authorization

[JWTBearer](../README.md#JWTBearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Item successfully withdraw from your bank. |  -  |
| **404** | Item not found. |  -  |
| **498** | Character not found. |  -  |
| **499** | Character in cooldown. |  -  |
| **461** | A transaction is already in progress with this item/your golds in your bank. |  -  |
| **486** | An action is already in progress by your character. |  -  |
| **497** | Character inventory is full. |  -  |
| **598** | Bank not found on this map. |  -  |
| **478** | Missing item or insufficient quantity in your inventory. |  -  |

<a id="getAllCharactersLogsMyLogsGet"></a>
# **getAllCharactersLogsMyLogsGet**
> DataPageLogSchema getAllCharactersLogsMyLogsGet(page, size)

Get All Characters Logs

History of the last 100 actions of all your characters.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.MyCharactersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure HTTP bearer authorization: JWTBearer
    HttpBearerAuth JWTBearer = (HttpBearerAuth) defaultClient.getAuthentication("JWTBearer");
    JWTBearer.setBearerToken("BEARER TOKEN");

    MyCharactersApi apiInstance = new MyCharactersApi(defaultClient);
    Integer page = 1; // Integer | Page number
    Integer size = 50; // Integer | Page size
    try {
      DataPageLogSchema result = apiInstance.getAllCharactersLogsMyLogsGet(page, size);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MyCharactersApi#getAllCharactersLogsMyLogsGet");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **page** | **Integer**| Page number | [optional] [default to 1] |
| **size** | **Integer**| Page size | [optional] [default to 50] |

### Return type

[**DataPageLogSchema**](DataPageLogSchema.md)

### Authorization

[JWTBearer](../README.md#JWTBearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully fetched logs. |  -  |
| **404** | Logs not found. |  -  |
| **498** | Character not found. |  -  |

<a id="getMyCharactersMyCharactersGet"></a>
# **getMyCharactersMyCharactersGet**
> MyCharactersListSchema getMyCharactersMyCharactersGet()

Get My Characters

List of your characters.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.MyCharactersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure HTTP bearer authorization: JWTBearer
    HttpBearerAuth JWTBearer = (HttpBearerAuth) defaultClient.getAuthentication("JWTBearer");
    JWTBearer.setBearerToken("BEARER TOKEN");

    MyCharactersApi apiInstance = new MyCharactersApi(defaultClient);
    try {
      MyCharactersListSchema result = apiInstance.getMyCharactersMyCharactersGet();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MyCharactersApi#getMyCharactersMyCharactersGet");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**MyCharactersListSchema**](MyCharactersListSchema.md)

### Authorization

[JWTBearer](../README.md#JWTBearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully fetched characters. |  -  |
| **404** | Characters not found. |  -  |

