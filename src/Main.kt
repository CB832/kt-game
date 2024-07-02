fun main() {
    var room1 = Location("Bar","Loud and noisy", mutableSetOf(), mutableSetOf())
    var sword = Item("Death", 50.0, Rarity.Rare, 3.0)
    var apple = Item("Apple", 1.0, Rarity.Common, 3.0)
    var player = Entity("Jack",16.0, mutableSetOf(), room1)
    var zombie = Entity("Zombie",100.0, mutableSetOf(), room1)
    player.inventory.add(sword)
    for (item in player.inventory) {
        println(item.name)
    }
    room1.entities.add(player)
    room1.entities.add(zombie)
    room1.items.add(apple)
    println("${room1.name} entities")
    for (entity in room1.entities) {
        println(entity.name)
    }
    println("${room1.name} items")
    for (item in room1.items) {
        println(item.name)
    }
}