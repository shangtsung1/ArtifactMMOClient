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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openapitools.client.model.AnnouncementSchema;

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
 * StatusSchema
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-08-09T17:40:21.793932300+10:00[Australia/Sydney]", comments = "Generator version: 7.6.0")
public class StatusSchema {
  public static final String SERIALIZED_NAME_STATUS = "status";
  @SerializedName(SERIALIZED_NAME_STATUS)
  private String status;

  public static final String SERIALIZED_NAME_VERSION = "version";
  @SerializedName(SERIALIZED_NAME_VERSION)
  private String version;

  public static final String SERIALIZED_NAME_CHARACTERS_ONLINE = "characters_online";
  @SerializedName(SERIALIZED_NAME_CHARACTERS_ONLINE)
  private Integer charactersOnline;

  public static final String SERIALIZED_NAME_SERVER_TIME = "server_time";
  @SerializedName(SERIALIZED_NAME_SERVER_TIME)
  private OffsetDateTime serverTime;

  public static final String SERIALIZED_NAME_ANNOUNCEMENTS = "announcements";
  @SerializedName(SERIALIZED_NAME_ANNOUNCEMENTS)
  private List<AnnouncementSchema> announcements = new ArrayList<>();

  public static final String SERIALIZED_NAME_LAST_WIPE = "last_wipe";
  @SerializedName(SERIALIZED_NAME_LAST_WIPE)
  private String lastWipe;

  public static final String SERIALIZED_NAME_NEXT_WIPE = "next_wipe";
  @SerializedName(SERIALIZED_NAME_NEXT_WIPE)
  private String nextWipe;

  public StatusSchema() {
  }

  public StatusSchema status(String status) {
    this.status = status;
    return this;
  }

   /**
   * Server status
   * @return status
  **/
  @javax.annotation.Nonnull
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }


  public StatusSchema version(String version) {
    this.version = version;
    return this;
  }

   /**
   * Get version
   * @return version
  **/
  @javax.annotation.Nullable
  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }


  public StatusSchema charactersOnline(Integer charactersOnline) {
    this.charactersOnline = charactersOnline;
    return this;
  }

   /**
   * Get charactersOnline
   * @return charactersOnline
  **/
  @javax.annotation.Nullable
  public Integer getCharactersOnline() {
    return charactersOnline;
  }

  public void setCharactersOnline(Integer charactersOnline) {
    this.charactersOnline = charactersOnline;
  }


  public StatusSchema serverTime(OffsetDateTime serverTime) {
    this.serverTime = serverTime;
    return this;
  }

   /**
   * Get serverTime
   * @return serverTime
  **/
  @javax.annotation.Nullable
  public OffsetDateTime getServerTime() {
    return serverTime;
  }

  public void setServerTime(OffsetDateTime serverTime) {
    this.serverTime = serverTime;
  }


  public StatusSchema announcements(List<AnnouncementSchema> announcements) {
    this.announcements = announcements;
    return this;
  }

  public StatusSchema addAnnouncementsItem(AnnouncementSchema announcementsItem) {
    if (this.announcements == null) {
      this.announcements = new ArrayList<>();
    }
    this.announcements.add(announcementsItem);
    return this;
  }

   /**
   * Get announcements
   * @return announcements
  **/
  @javax.annotation.Nullable
  public List<AnnouncementSchema> getAnnouncements() {
    return announcements;
  }

  public void setAnnouncements(List<AnnouncementSchema> announcements) {
    this.announcements = announcements;
  }


  public StatusSchema lastWipe(String lastWipe) {
    this.lastWipe = lastWipe;
    return this;
  }

   /**
   * Last server wipe.
   * @return lastWipe
  **/
  @javax.annotation.Nonnull
  public String getLastWipe() {
    return lastWipe;
  }

  public void setLastWipe(String lastWipe) {
    this.lastWipe = lastWipe;
  }


  public StatusSchema nextWipe(String nextWipe) {
    this.nextWipe = nextWipe;
    return this;
  }

   /**
   * Next server wipe.
   * @return nextWipe
  **/
  @javax.annotation.Nonnull
  public String getNextWipe() {
    return nextWipe;
  }

  public void setNextWipe(String nextWipe) {
    this.nextWipe = nextWipe;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StatusSchema statusSchema = (StatusSchema) o;
    return Objects.equals(this.status, statusSchema.status) &&
        Objects.equals(this.version, statusSchema.version) &&
        Objects.equals(this.charactersOnline, statusSchema.charactersOnline) &&
        Objects.equals(this.serverTime, statusSchema.serverTime) &&
        Objects.equals(this.announcements, statusSchema.announcements) &&
        Objects.equals(this.lastWipe, statusSchema.lastWipe) &&
        Objects.equals(this.nextWipe, statusSchema.nextWipe);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, version, charactersOnline, serverTime, announcements, lastWipe, nextWipe);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StatusSchema {\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    charactersOnline: ").append(toIndentedString(charactersOnline)).append("\n");
    sb.append("    serverTime: ").append(toIndentedString(serverTime)).append("\n");
    sb.append("    announcements: ").append(toIndentedString(announcements)).append("\n");
    sb.append("    lastWipe: ").append(toIndentedString(lastWipe)).append("\n");
    sb.append("    nextWipe: ").append(toIndentedString(nextWipe)).append("\n");
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
    openapiFields.add("status");
    openapiFields.add("version");
    openapiFields.add("characters_online");
    openapiFields.add("server_time");
    openapiFields.add("announcements");
    openapiFields.add("last_wipe");
    openapiFields.add("next_wipe");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("status");
    openapiRequiredFields.add("last_wipe");
    openapiRequiredFields.add("next_wipe");
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to StatusSchema
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!StatusSchema.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in StatusSchema is not found in the empty JSON string", StatusSchema.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!StatusSchema.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `StatusSchema` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : StatusSchema.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if (!jsonObj.get("status").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `status` to be a primitive type in the JSON string but got `%s`", jsonObj.get("status").toString()));
      }
      if ((jsonObj.get("version") != null && !jsonObj.get("version").isJsonNull()) && !jsonObj.get("version").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `version` to be a primitive type in the JSON string but got `%s`", jsonObj.get("version").toString()));
      }
      if (jsonObj.get("announcements") != null && !jsonObj.get("announcements").isJsonNull()) {
        JsonArray jsonArrayannouncements = jsonObj.getAsJsonArray("announcements");
        if (jsonArrayannouncements != null) {
          // ensure the json data is an array
          if (!jsonObj.get("announcements").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `announcements` to be an array in the JSON string but got `%s`", jsonObj.get("announcements").toString()));
          }

          // validate the optional field `announcements` (array)
          for (int i = 0; i < jsonArrayannouncements.size(); i++) {
            AnnouncementSchema.validateJsonElement(jsonArrayannouncements.get(i));
          };
        }
      }
      if (!jsonObj.get("last_wipe").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `last_wipe` to be a primitive type in the JSON string but got `%s`", jsonObj.get("last_wipe").toString()));
      }
      if (!jsonObj.get("next_wipe").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `next_wipe` to be a primitive type in the JSON string but got `%s`", jsonObj.get("next_wipe").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!StatusSchema.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'StatusSchema' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<StatusSchema> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(StatusSchema.class));

       return (TypeAdapter<T>) new TypeAdapter<StatusSchema>() {
           @Override
           public void write(JsonWriter out, StatusSchema value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public StatusSchema read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of StatusSchema given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of StatusSchema
  * @throws IOException if the JSON string is invalid with respect to StatusSchema
  */
  public static StatusSchema fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, StatusSchema.class);
  }

 /**
  * Convert an instance of StatusSchema to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

