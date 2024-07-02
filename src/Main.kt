fun main() {
    var sword = Item("Death", 50.0, Rarity.Rare, 3.0)
    var player = Entity("Jack",16.0, mutableSetOf())
    player.inventory.add(sword)
    for (item in player.inventory) {
        println(item.name)
    }
}