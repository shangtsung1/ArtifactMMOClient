# GrandExchangeApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getAllGeItemsGeGet**](GrandExchangeApi.md#getAllGeItemsGeGet) | **GET** /ge/ | Get All Ge Items |
| [**getGeItemGeCodeGet**](GrandExchangeApi.md#getGeItemGeCodeGet) | **GET** /ge/{code} | Get Ge Item |


<a id="getAllGeItemsGeGet"></a>
# **getAllGeItemsGeGet**
> DataPageGEItemSchema getAllGeItemsGeGet(page, size)

Get All Ge Items

Fetch Grand Exchange items details.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.GrandExchangeApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    GrandExchangeApi apiInstance = new GrandExchangeApi(defaultClient);
    Integer page = 1; // Integer | Page number
    Integer size = 50; // Integer | Page size
    try {
      DataPageGEItemSchema result = apiInstance.getAllGeItemsGeGet(page, size);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling GrandExchangeApi#getAllGeItemsGeGet");
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

[**DataPageGEItemSchema**](DataPageGEItemSchema.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Fetch Grand Exchange items details. |  -  |
| **404** | Item not found. |  -  |

<a id="getGeItemGeCodeGet"></a>
# **getGeItemGeCodeGet**
> GEItemResponseSchema getGeItemGeCodeGet(code)

Get Ge Item

Retrieve the details of a Grand Exchange item.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.GrandExchangeApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    GrandExchangeApi apiInstance = new GrandExchangeApi(defaultClient);
    String code = "code_example"; // String | The code of the item.
    try {
      GEItemResponseSchema result = apiInstance.getGeItemGeCodeGet(code);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling GrandExchangeApi#getGeItemGeCodeGet");
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
| **code** | **String**| The code of the item. | |

### Return type

[**GEItemResponseSchema**](GEItemResponseSchema.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully fetched Grand Exchange item. |  -  |
| **404** | Item not found. |  -  |

