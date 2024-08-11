

# CraftSchema


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**skill** | [**SkillEnum**](#SkillEnum) | Skill required to craft the item. |  [optional] |
|**level** | **Integer** | The skill level required to craft the item. |  [optional] |
|**items** | [**List&lt;SimpleItemSchema&gt;**](SimpleItemSchema.md) | List of items required to craft the item. |  [optional] |
|**quantity** | **Integer** | Quantity of items crafted. |  [optional] |



## Enum: SkillEnum

| Name | Value |
|---- | -----|
| WEAPONCRAFTING | &quot;weaponcrafting&quot; |
| GEARCRAFTING | &quot;gearcrafting&quot; |
| JEWELRYCRAFTING | &quot;jewelrycrafting&quot; |
| COOKING | &quot;cooking&quot; |
| WOODCUTTING | &quot;woodcutting&quot; |
| MINING | &quot;mining&quot; |



