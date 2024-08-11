

# FightSchema


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**xp** | **Integer** | The amount of xp gained by the fight. |  |
|**gold** | **Integer** | The amount of gold gained by the fight. |  |
|**drops** | [**List&lt;DropSchema&gt;**](DropSchema.md) | The items dropped by the fight. |  |
|**turns** | **Integer** | Numbers of the turns of the combat. |  |
|**monsterBlockedHits** | [**BlockedHitsSchema**](BlockedHitsSchema.md) | The amount of blocked hits by the monster. |  |
|**playerBlockedHits** | [**BlockedHitsSchema**](BlockedHitsSchema.md) | The amount of blocked hits by the player. |  |
|**logs** | **List&lt;String&gt;** | The fight logs. |  |
|**result** | [**ResultEnum**](#ResultEnum) | The result of the fight. |  |



## Enum: ResultEnum

| Name | Value |
|---- | -----|
| WIN | &quot;win&quot; |
| LOSE | &quot;lose&quot; |



