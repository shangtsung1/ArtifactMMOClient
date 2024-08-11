# MyAccountApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**changePasswordMyChangePasswordPost**](MyAccountApi.md#changePasswordMyChangePasswordPost) | **POST** /my/change_password | Change Password |
| [**getBankGoldsMyBankGoldGet**](MyAccountApi.md#getBankGoldsMyBankGoldGet) | **GET** /my/bank/gold | Get Bank Golds |
| [**getBankItemsMyBankItemsGet**](MyAccountApi.md#getBankItemsMyBankItemsGet) | **GET** /my/bank/items | Get Bank Items |


<a id="changePasswordMyChangePasswordPost"></a>
# **changePasswordMyChangePasswordPost**
> ResponseSchema changePasswordMyChangePasswordPost(changePassword)

Change Password

Change your account password. Changing the password reset the account token.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.MyAccountApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure HTTP bearer authorization: JWTBearer
    HttpBearerAuth JWTBearer = (HttpBearerAuth) defaultClient.getAuthentication("JWTBearer");
    JWTBearer.setBearerToken("BEARER TOKEN");

    MyAccountApi apiInstance = new MyAccountApi(defaultClient);
    ChangePassword changePassword = new ChangePassword(); // ChangePassword | 
    try {
      ResponseSchema result = apiInstance.changePasswordMyChangePasswordPost(changePassword);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MyAccountApi#changePasswordMyChangePasswordPost");
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
| **changePassword** | [**ChangePassword**](ChangePassword.md)|  | |

### Return type

[**ResponseSchema**](ResponseSchema.md)

### Authorization

[JWTBearer](../README.md#JWTBearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Password changed successfully. |  -  |
| **458** | Use a different password. |  -  |

<a id="getBankGoldsMyBankGoldGet"></a>
# **getBankGoldsMyBankGoldGet**
> GoldBankResponseSchema getBankGoldsMyBankGoldGet()

Get Bank Golds

Fetch golds in your bank.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.MyAccountApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure HTTP bearer authorization: JWTBearer
    HttpBearerAuth JWTBearer = (HttpBearerAuth) defaultClient.getAuthentication("JWTBearer");
    JWTBearer.setBearerToken("BEARER TOKEN");

    MyAccountApi apiInstance = new MyAccountApi(defaultClient);
    try {
      GoldBankResponseSchema result = apiInstance.getBankGoldsMyBankGoldGet();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MyAccountApi#getBankGoldsMyBankGoldGet");
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

[**GoldBankResponseSchema**](GoldBankResponseSchema.md)

### Authorization

[JWTBearer](../README.md#JWTBearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully fetched golds. |  -  |

<a id="getBankItemsMyBankItemsGet"></a>
# **getBankItemsMyBankItemsGet**
> DataPageSimpleItemSchema getBankItemsMyBankItemsGet(itemCode, page, size)

Get Bank Items

Fetch all items in your bank.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.MyAccountApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure HTTP bearer authorization: JWTBearer
    HttpBearerAuth JWTBearer = (HttpBearerAuth) defaultClient.getAuthentication("JWTBearer");
    JWTBearer.setBearerToken("BEARER TOKEN");

    MyAccountApi apiInstance = new MyAccountApi(defaultClient);
    String itemCode = "itemCode_example"; // String | Item to search in your bank.
    Integer page = 1; // Integer | Page number
    Integer size = 50; // Integer | Page size
    try {
      DataPageSimpleItemSchema result = apiInstance.getBankItemsMyBankItemsGet(itemCode, page, size);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MyAccountApi#getBankItemsMyBankItemsGet");
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
| **itemCode** | **String**| Item to search in your bank. | [optional] |
| **page** | **Integer**| Page number | [optional] [default to 1] |
| **size** | **Integer**| Page size | [optional] [default to 50] |

### Return type

[**DataPageSimpleItemSchema**](DataPageSimpleItemSchema.md)

### Authorization

[JWTBearer](../README.md#JWTBearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully fetched items. |  -  |
| **404** | Items not found. |  -  |

