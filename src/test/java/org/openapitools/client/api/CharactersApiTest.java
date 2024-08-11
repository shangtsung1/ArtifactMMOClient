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
import org.openapitools.client.model.AddCharacterSchema;
import org.openapitools.client.model.CharacterResponseSchema;
import org.openapitools.client.model.DataPageCharacterSchema;
import org.openapitools.client.model.DeleteCharacterSchema;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for CharactersApi
 */
@Disabled
public class CharactersApiTest {

    private final CharactersApi api = new CharactersApi();

    /**
     * Create Character
     *
     * Create new character on your account. You can create up to 5 characters.
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void createCharacterCharactersCreatePostTest() throws ApiException {
        AddCharacterSchema addCharacterSchema = null;
        CharacterResponseSchema response = api.createCharacterCharactersCreatePost(addCharacterSchema);
        // TODO: test validations
    }

    /**
     * Delete Character
     *
     * Delete character on your account.
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void deleteCharacterCharactersDeletePostTest() throws ApiException {
        DeleteCharacterSchema deleteCharacterSchema = null;
        CharacterResponseSchema response = api.deleteCharacterCharactersDeletePost(deleteCharacterSchema);
        // TODO: test validations
    }

    /**
     * Get All Characters
     *
     * Fetch characters details.
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getAllCharactersCharactersGetTest() throws ApiException {
        String sort = null;
        Integer page = null;
        Integer size = null;
        DataPageCharacterSchema response = api.getAllCharactersCharactersGet(sort, page, size);
        // TODO: test validations
    }

    /**
     * Get Character
     *
     * Retrieve the details of a character.
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getCharacterCharactersNameGetTest() throws ApiException {
        String name = null;
        CharacterResponseSchema response = api.getCharacterCharactersNameGet(name);
        // TODO: test validations
    }

}
