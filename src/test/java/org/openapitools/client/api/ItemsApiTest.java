/*
 * Artifacts API
 *  Artifacts is an API-based MMO game where you can manage 5 characters to explore, fight, gather resources, craft items and much more.  Website: https://artifactsmmo.com/  Documentation: https://docs.artifactsmmo.com/  OpenAPI Spec: https://api.artifactsmmo.com/openapi.json 
 *
 * The version of the OpenAPI document: 1.6
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.openapitools.client.api;

import org.openapitools.client.ApiException;
import org.openapitools.client.model.DataPageItemSchema;
import org.openapitools.client.model.ItemResponseSchema;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for ItemsApi
 */
@Disabled
public class ItemsApiTest {

    private final ItemsApi api = new ItemsApi();

    /**
     * Get All Items
     *
     * Fetch items details.
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getAllItemsItemsGetTest() throws ApiException {
        Integer minLevel = null;
        Integer maxLevel = null;
        String name = null;
        String type = null;
        String craftSkill = null;
        String craftMaterial = null;
        Integer page = null;
        Integer size = null;
        DataPageItemSchema response = api.getAllItemsItemsGet(minLevel, maxLevel, name, type, craftSkill, craftMaterial, page, size);
        // TODO: test validations
    }

    /**
     * Get Item
     *
     * Retrieve the details of a item.
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getItemItemsCodeGetTest() throws ApiException {
        String code = null;
        ItemResponseSchema response = api.getItemItemsCodeGet(code);
        // TODO: test validations
    }

}
