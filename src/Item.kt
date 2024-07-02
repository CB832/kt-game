enum class Rarity {
    Common,
    Uncommon,
    Legendary,
    Rare,
    Epic
}

class Item (
    var name: String,
    var value: Double,
    var rarity: Rarity,
    var weight: Double,
)