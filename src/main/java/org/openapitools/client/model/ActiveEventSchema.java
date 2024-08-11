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


package org.openapitools.client.model;

import java.util.Objects;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.Arrays;
import org.openapitools.client.model.MapSchema;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openapitools.client.JSON;

/**
 * ActiveEventSchema
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-08-09T17:40:21.793932300+10:00[Australia/Sydney]", comments = "Generator version: 7.6.0")
public class ActiveEventSchema {
  public static final String SERIALIZED_NAME_NAME = "name";
  @SerializedName(SERIALIZED_NAME_NAME)
  private String name;

  public static final String SERIALIZED_NAME_MAP = "map";
  @SerializedName(SERIALIZED_NAME_MAP)
  private MapSchema map;

  public static final String SERIALIZED_NAME_PREVIOUS_SKIN = "previous_skin";
  @SerializedName(SERIALIZED_NAME_PREVIOUS_SKIN)
  private String previousSkin;

  public static final String SERIALIZED_NAME_DURATION = "duration";
  @SerializedName(SERIALIZED_NAME_DURATION)
  private Integer duration;

  public static final String SERIALIZED_NAME_EXPIRATION = "expiration";
  @SerializedName(SERIALIZED_NAME_EXPIRATION)
  private OffsetDateTime expiration;

  public static final String SERIALIZED_NAME_CREATED_AT = "created_at";
  @SerializedName(SERIALIZED_NAME_CREATED_AT)
  private OffsetDateTime createdAt;

  public ActiveEventSchema() {
  }

  public ActiveEventSchema name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Name of the event.
   * @return name
  **/
  @javax.annotation.Nonnull
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public ActiveEventSchema map(MapSchema map) {
    this.map = map;
    return this;
  }

   /**
   * Map of the event.
   * @return map
  **/
  @javax.annotation.Nonnull
  public MapSchema getMap() {
    return map;
  }

  public void setMap(MapSchema map) {
    this.map = map;
  }


  public ActiveEventSchema previousSkin(String previousSkin) {
    this.previousSkin = previousSkin;
    return this;
  }

   /**
   * Previous map skin.
   * @return previousSkin
  **/
  @javax.annotation.Nonnull
  public String getPreviousSkin() {
    return previousSkin;
  }

  public void setPreviousSkin(String previousSkin) {
    this.previousSkin = previousSkin;
  }


  public ActiveEventSchema duration(Integer duration) {
    this.duration = duration;
    return this;
  }

   /**
   * Duration in minutes.
   * @return duration
  **/
  @javax.annotation.Nonnull
  public Integer getDuration() {
    return duration;
  }

  public void setDuration(Integer duration) {
    this.duration = duration;
  }


  public ActiveEventSchema expiration(OffsetDateTime expiration) {
    this.expiration = expiration;
    return this;
  }

   /**
   * Expiration datetime.
   * @return expiration
  **/
  @javax.annotation.Nonnull
  public OffsetDateTime getExpiration() {
    return expiration;
  }

  public void setExpiration(OffsetDateTime expiration) {
    this.expiration = expiration;
  }


  public ActiveEventSchema createdAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

   /**
   * Start datetime.
   * @return createdAt
  **/
  @javax.annotation.Nonnull
  public OffsetDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ActiveEventSchema activeEventSchema = (ActiveEventSchema) o;
    return Objects.equals(this.name, activeEventSchema.name) &&
        Objects.equals(this.map, activeEventSchema.map) &&
        Objects.equals(this.previousSkin, activeEventSchema.previousSkin) &&
        Objects.equals(this.duration, activeEventSchema.duration) &&
        Objects.equals(this.expiration, activeEventSchema.expiration) &&
        Objects.equals(this.createdAt, activeEventSchema.createdAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, map, previousSkin, duration, expiration, createdAt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ActiveEventSchema {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    map: ").append(toIndentedString(map)).append("\n");
    sb.append("    previousSkin: ").append(toIndentedString(previousSkin)).append("\n");
    sb.append("    duration: ").append(toIndentedString(duration)).append("\n");
    sb.append("    expiration: ").append(toIndentedString(expiration)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }


  public static HashSet<String> openapiFields;
  public static HashSet<String> openapiRequiredFields;

  static {
    // a set of all properties/fields (JSON key names)
    openapiFields = new HashSet<String>();
    openapiFields.add("name");
    openapiFields.add("map");
    openapiFields.add("previous_skin");
    openapiFields.add("duration");
    openapiFields.add("expiration");
    openapiFields.add("created_at");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("name");
    openapiRequiredFields.add("map");
    openapiRequiredFields.add("previous_skin");
    openapiRequiredFields.add("duration");
    openapiRequiredFields.add("expiration");
    openapiRequiredFields.add("created_at");
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to ActiveEventSchema
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!ActiveEventSchema.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in ActiveEventSchema is not found in the empty JSON string", ActiveEventSchema.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!ActiveEventSchema.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `ActiveEventSchema` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : ActiveEventSchema.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if (!jsonObj.get("name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("name").toString()));
      }
      // validate the required field `map`
      MapSchema.validateJsonElement(jsonObj.get("map"));
      if (!jsonObj.get("previous_skin").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `previous_skin` to be a primitive type in the JSON string but got `%s`", jsonObj.get("previous_skin").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!ActiveEventSchema.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'ActiveEventSchema' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<ActiveEventSchema> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(ActiveEventSchema.class));

       return (TypeAdapter<T>) new TypeAdapter<ActiveEventSchema>() {
           @Override
           public void write(JsonWriter out, ActiveEventSchema value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public ActiveEventSchema read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of ActiveEventSchema given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of ActiveEventSchema
  * @throws IOException if the JSON string is invalid with respect to ActiveEventSchema
  */
  public static ActiveEventSchema fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, ActiveEventSchema.class);
  }

 /**
  * Convert an instance of ActiveEventSchema to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

