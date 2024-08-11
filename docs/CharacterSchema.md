

# CharacterSchema


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**name** | **String** | Name of the character. |  |
|**skin** | [**SkinEnum**](#SkinEnum) | Character skin code. |  |
|**level** | **Integer** | Combat level. |  |
|**xp** | **Integer** | The current xp level of the combat level. |  |
|**maxXp** | **Integer** | XP required to level up the character. |  |
|**totalXp** | **Integer** | Total XP of your character. |  |
|**gold** | **Integer** | The numbers of golds on this character. |  |
|**speed** | **Integer** | *Not available, on the roadmap. Character movement speed. |  |
|**miningLevel** | **Integer** | Mining level. |  |
|**miningXp** | **Integer** | The current xp level of the Mining skill. |  |
|**miningMaxXp** | **Integer** | Mining XP required to level up the skill. |  |
|**woodcuttingLevel** | **Integer** | Woodcutting level. |  |
|**woodcuttingXp** | **Integer** | The current xp level of the Woodcutting skill. |  |
|**woodcuttingMaxXp** | **Integer** | Woodcutting XP required to level up the skill. |  |
|**fishingLevel** | **Integer** | Fishing level. |  |
|**fishingXp** | **Integer** | The current xp level of the Fishing skill. |  |
|**fishingMaxXp** | **Integer** | Fishing XP required to level up the skill. |  |
|**weaponcraftingLevel** | **Integer** | Weaponcrafting level. |  |
|**weaponcraftingXp** | **Integer** | The current xp level of the Weaponcrafting skill. |  |
|**weaponcraftingMaxXp** | **Integer** | Weaponcrafting XP required to level up the skill. |  |
|**gearcraftingLevel** | **Integer** | Gearcrafting level. |  |
|**gearcraftingXp** | **Integer** | The current xp level of the Gearcrafting skill. |  |
|**gearcraftingMaxXp** | **Integer** | Gearcrafting XP required to level up the skill. |  |
|**jewelrycraftingLevel** | **Integer** | Jewelrycrafting level. |  |
|**jewelrycraftingXp** | **Integer** | The current xp level of the Jewelrycrafting skill. |  |
|**jewelrycraftingMaxXp** | **Integer** | Jewelrycrafting XP required to level up the skill. |  |
|**cookingLevel** | **Integer** | The current xp level of the Cooking skill. |  |
|**cookingXp** | **Integer** | Cooking XP. |  |
|**cookingMaxXp** | **Integer** | Cooking XP required to level up the skill. |  |
|**hp** | **Integer** | Character HP. |  |
|**haste** | **Integer** | *Character Haste. Increase speed attack (reduce fight cooldown) |  |
|**criticalStrike** | **Integer** | *Not available, on the roadmap. Character Critical   Strike. Critical strikes increase the attack&#39;s damage. |  |
|**stamina** | **Integer** | *Not available, on the roadmap. Regenerates life at the start of each turn. |  |
|**attackFire** | **Integer** | Fire attack. |  |
|**attackEarth** | **Integer** | Earth attack. |  |
|**attackWater** | **Integer** | Water attack. |  |
|**attackAir** | **Integer** | Air attack. |  |
|**dmgFire** | **Integer** | % Fire damage. |  |
|**dmgEarth** | **Integer** | % Earth damage. |  |
|**dmgWater** | **Integer** | % Water damage. |  |
|**dmgAir** | **Integer** | % Air damage. |  |
|**resFire** | **Integer** | % Fire resistance. |  |
|**resEarth** | **Integer** | % Earth resistance. |  |
|**resWater** | **Integer** | % Water resistance. |  |
|**resAir** | **Integer** | % Air resistance. |  |
|**x** | **Integer** | Character x coordinate. |  |
|**y** | **Integer** | Character y coordinate. |  |
|**cooldown** | **Integer** | Cooldown in seconds. |  |
|**cooldownExpiration** | **OffsetDateTime** | Datetime Cooldown expiration. |  [optional] |
|**weaponSlot** | **String** | Weapon slot. |  |
|**shieldSlot** | **String** | Shield slot. |  |
|**helmetSlot** | **String** | Helmet slot. |  |
|**bodyArmorSlot** | **String** | Body armor slot. |  |
|**legArmorSlot** | **String** | Leg armor slot. |  |
|**bootsSlot** | **String** | Boots slot. |  |
|**ring1Slot** | **String** | Ring 1 slot. |  |
|**ring2Slot** | **String** | Ring 2 slot. |  |
|**amuletSlot** | **String** | Amulet slot. |  |
|**artifact1Slot** | **String** | Artifact 1 slot. |  |
|**artifact2Slot** | **String** | Artifact 2 slot. |  |
|**artifact3Slot** | **String** | Artifact 3 slot. |  |
|**consumable1Slot** | **String** | Consumable 1 slot. |  |
|**consumable1SlotQuantity** | **Integer** | Consumable 1 quantity. |  |
|**consumable2Slot** | **String** | Consumable 2 slot. |  |
|**consumable2SlotQuantity** | **Integer** | Consumable 2 quantity. |  |
|**task** | **String** | Task in progress. |  |
|**taskType** | **String** | Task type. |  |
|**taskProgress** | **Integer** | Task progression. |  |
|**taskTotal** | **Integer** | Task total objective. |  |
|**inventoryMaxItems** | **Integer** | Inventory max items. |  |
|**inventory** | [**List&lt;InventorySlot&gt;**](InventorySlot.md) | List of inventory slots. |  [optional] |



## Enum: SkinEnum

| Name | Value |
|---- | -----|
| MEN1 | &quot;men1&quot; |
| MEN2 | &quot;men2&quot; |
| MEN3 | &quot;men3&quot; |
| WOMEN1 | &quot;women1&quot; |
| WOMEN2 | &quot;women2&quot; |
| WOMEN3 | &quot;women3&quot; |



