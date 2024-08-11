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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openapitools.client.model.SimpleItemSchema;

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
 * CraftSchema
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-08-09T17:40:21.793932300+10:00[Australia/Sydney]", comments = "Generator version: 7.6.0")
public class CraftSchema {
  /**
   * Skill required to craft the item.
   */
  @JsonAdapter(SkillEnum.Adapter.class)
  public enum SkillEnum {
    WEAPONCRAFTING("weaponcrafting"),
    
    GEARCRAFTING("gearcrafting"),
    
    JEWELRYCRAFTING("jewelrycrafting"),
    
    COOKING("cooking"),
    
    WOODCUTTING("woodcutting"),
    
    MINING("mining");

    private String value;

    SkillEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static SkillEnum fromValue(String value) {
      for (SkillEnum b : SkillEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<SkillEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final SkillEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public SkillEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return SkillEnum.fromValue(value);
      }
    }

    public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      String value = jsonElement.getAsString();
      SkillEnum.fromValue(value);
    }
  }

  public static final String SERIALIZED_NAME_SKILL = "skill";
  @SerializedName(SERIALIZED_NAME_SKILL)
  private SkillEnum skill;

  public static final String SERIALIZED_NAME_LEVEL = "level";
  @SerializedName(SERIALIZED_NAME_LEVEL)
  private Integer level;

  public static final String SERIALIZED_NAME_ITEMS = "items";
  @SerializedName(SERIALIZED_NAME_ITEMS)
  private List<SimpleItemSchema> items = new ArrayList<>();

  public static final String SERIALIZED_NAME_QUANTITY = "quantity";
  @SerializedName(SERIALIZED_NAME_QUANTITY)
  private Integer quantity;

  public CraftSchema() {
  }

  public CraftSchema skill(SkillEnum skill) {
    this.skill = skill;
    return this;
  }

   /**
   * Skill required to craft the item.
   * @return skill
  **/
  @javax.annotation.Nullable
  public SkillEnum getSkill() {
    return skill;
  }

  public void setSkill(SkillEnum skill) {
    this.skill = skill;
  }


  public CraftSchema level(Integer level) {
    this.level = level;
    return this;
  }

   /**
   * The skill level required to craft the item.
   * @return level
  **/
  @javax.annotation.Nullable
  public Integer getLevel() {
    return level;
  }

  public void setLevel(Integer level) {
    this.level = level;
  }


  public CraftSchema items(List<SimpleItemSchema> items) {
    this.items = items;
    return this;
  }

  public CraftSchema addItemsItem(SimpleItemSchema itemsItem) {
    if (this.items == null) {
      this.items = new ArrayList<>();
    }
    this.items.add(itemsItem);
    return this;
  }

   /**
   * List of items required to craft the item.
   * @return items
  **/
  @javax.annotation.Nullable
  public List<SimpleItemSchema> getItems() {
    return items;
  }

  public void setItems(List<SimpleItemSchema> items) {
    this.items = items;
  }


  public CraftSchema quantity(Integer quantity) {
    this.quantity = quantity;
    return this;
  }

   /**
   * Quantity of items crafted.
   * @return quantity
  **/
  @javax.annotation.Nullable
  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CraftSchema craftSchema = (CraftSchema) o;
    return Objects.equals(this.skill, craftSchema.skill) &&
        Objects.equals(this.level, craftSchema.level) &&
        Objects.equals(this.items, craftSchema.items) &&
        Objects.equals(this.quantity, craftSchema.quantity);
  }

  @Override
  public int hashCode() {
    return Objects.hash(skill, level, items, quantity);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CraftSchema {\n");
    sb.append("    skill: ").append(toIndentedString(skill)).append("\n");
    sb.append("    level: ").append(toIndentedString(level)).append("\n");
    sb.append("    items: ").append(toIndentedString(items)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
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
    openapiFields.add("skill");
    openapiFields.add("level");
    openapiFields.add("items");
    openapiFields.add("quantity");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to CraftSchema
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!CraftSchema.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in CraftSchema is not found in the empty JSON string", CraftSchema.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!CraftSchema.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `CraftSchema` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if ((jsonObj.get("skill") != null && !jsonObj.get("skill").isJsonNull()) && !jsonObj.get("skill").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `skill` to be a primitive type in the JSON string but got `%s`", jsonObj.get("skill").toString()));
      }
      // validate the optional field `skill`
      if (jsonObj.get("skill") != null && !jsonObj.get("skill").isJsonNull()) {
        SkillEnum.validateJsonElement(jsonObj.get("skill"));
      }
      if (jsonObj.get("items") != null && !jsonObj.get("items").isJsonNull()) {
        JsonArray jsonArrayitems = jsonObj.getAsJsonArray("items");
        if (jsonArrayitems != null) {
          // ensure the json data is an array
          if (!jsonObj.get("items").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `items` to be an array in the JSON string but got `%s`", jsonObj.get("items").toString()));
          }

          // validate the optional field `items` (array)
          for (int i = 0; i < jsonArrayitems.size(); i++) {
            SimpleItemSchema.validateJsonElement(jsonArrayitems.get(i));
          };
        }
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!CraftSchema.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'CraftSchema' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<CraftSchema> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(CraftSchema.class));

       return (TypeAdapter<T>) new TypeAdapter<CraftSchema>() {
           @Override
           public void write(JsonWriter out, CraftSchema value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public CraftSchema read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of CraftSchema given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of CraftSchema
  * @throws IOException if the JSON string is invalid with respect to CraftSchema
  */
  public static CraftSchema fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, CraftSchema.class);
  }

 /**
  * Convert an instance of CraftSchema to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

