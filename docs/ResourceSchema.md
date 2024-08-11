

# ResourceSchema


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**name** | **String** | The name of the resource |  |
|**code** | **String** | The code of the resource. This is the resource&#39;s unique identifier (ID). |  |
|**skill** | [**SkillEnum**](#SkillEnum) | The skill required to gather this resource. |  |
|**level** | **Integer** | The skill level required to gather this resource. |  |
|**drops** | [**List&lt;DropRateSchema&gt;**](DropRateSchema.md) | The drops of this resource. |  |



## Enum: SkillEnum

| Name | Value |
|---- | -----|
| MINING | &quot;mining&quot; |
| WOODCUTTING | &quot;woodcutting&quot; |
| FISHING | &quot;fishing&quot; |



