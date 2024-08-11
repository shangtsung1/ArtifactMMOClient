

# CooldownSchema


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**totalSeconds** | **Integer** | The total seconds of the cooldown. |  |
|**remainingSeconds** | **Integer** | The remaining seconds of the cooldown. |  |
|**startedAt** | **OffsetDateTime** | The start of the cooldown. |  |
|**expiration** | **OffsetDateTime** | The expiration of the cooldown. |  |
|**reason** | [**ReasonEnum**](#ReasonEnum) | The reason of the cooldown. |  |



## Enum: ReasonEnum

| Name | Value |
|---- | -----|
| MOVEMENT | &quot;movement&quot; |
| FIGHT | &quot;fight&quot; |
| CRAFTING | &quot;crafting&quot; |
| GATHERING | &quot;gathering&quot; |
| BUY_GE | &quot;buy_ge&quot; |
| SELL_GE | &quot;sell_ge&quot; |
| DELETE_ITEM | &quot;delete_item&quot; |
| DEPOSIT_BANK | &quot;deposit_bank&quot; |
| WITHDRAW_BANK | &quot;withdraw_bank&quot; |
| EQUIP | &quot;equip&quot; |
| UNEQUIP | &quot;unequip&quot; |
| TASK | &quot;task&quot; |
| RECYCLING | &quot;recycling&quot; |



