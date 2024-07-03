fun main() {
    var room1 = Location("Bar", "Loud and noisy", mutableSetOf(), mutableSetOf(), mutableSetOf())
    var room2 = Location("Home", "Quiet and warm", mutableSetOf(), mutableSetOf(), mutableSetOf())
    var sword = Item("Death", 50.0, Rarity.Rare, 3.0)
    var apple = Item("Apple", 1.0, Rarity.Common, 3.0)
    var player = Entity("Jack", 16.0, mutableSetOf(), room1)
    var zombie = Entity("Zombie", 100.0, mutableSetOf(), room1)
    player.inventory.add(sword)
    for (item in player.inventory) {
        println(item.name)
    }
    room1.destinations.add(room2)
    room2.destinations.add(room1)
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
    var running = true
    while (running == true) {
        println("Enter a command!")
        var command = readln()
        if (command == "quit") {
            running = false
            println("Goodbye")
        }
        if (command == "drop") {
            println("Which item would you like to drop?")
            var response = readln()
            for (item in player.inventory) {
                if (item.name == response) {
                    player.inventory.remove(item)
                    player.location.items.add(item)
                    continue
                }
            }
            println("You dont have that item")
        }
        if (command == "pickup") {
            println("Which item would you like to pickup?")
            var response = readln()
            for (item in player.location.items) {
                if (item.name == response) {
                    player.inventory.add(item)
                    player.location.items.remove(item)
                    continue
                }
            }
            println("That item is not in you vacinity")
        }
        if (command == "go to") {
            println("Where would you like to go?")
            var response = readln()
            for (location in player.location.destinations) {
                if (location.name == response) {
                    player.location = location
                }
            }
        }
    }
}