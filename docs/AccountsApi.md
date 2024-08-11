# AccountsApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createAccountAccountsCreatePost**](AccountsApi.md#createAccountAccountsCreatePost) | **POST** /accounts/create | Create Account |


<a id="createAccountAccountsCreatePost"></a>
# **createAccountAccountsCreatePost**
> ResponseSchema createAccountAccountsCreatePost(addAccountSchema)

Create Account

Create an account.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.AccountsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    AccountsApi apiInstance = new AccountsApi(defaultClient);
    AddAccountSchema addAccountSchema = new AddAccountSchema(); // AddAccountSchema | 
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
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **addAccountSchema** | [**AddAccountSchema**](AddAccountSchema.md)|  | |

### Return type

[**ResponseSchema**](ResponseSchema.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Account created successfully. |  -  |
| **456** | Username already used. |  -  |
| **457** | Email already used. |  -  |

