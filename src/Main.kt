fun main() {
    var room1 = Location("bar", "Loud and noisy", mutableSetOf(), mutableSetOf(), mutableSetOf())
    var room2 = Location("home", "Quiet and warm", mutableSetOf(), mutableSetOf(), mutableSetOf())
    var sword = Item("death", 50.0, Rarity.Rare, 3.0)
    var apple = Item("apple", 1.0, Rarity.Common, 3.0)
    var player = Entity("jack", 16.0, mutableSetOf(), room1, 10.0)
    var zombie = Entity("zombie", 100.0, mutableSetOf(), room1, 10.0)
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
    gameloop@
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
                    println("You have dropped ${item.name}")
                    continue@gameloop
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
                    println("You have picked up ${item.name}")
                    continue@gameloop
                }
            }
            println("That item is not in you vacinity")
        }
        if (command == "goto") {
            println("Where would you like to go?")
            var response = readln()
            for (location in player.location.destinations) {
                if (location.name == response) {
                    player.location = location
                    println("You are now at ${player.location.name}")
                    continue@gameloop
                }
            }
            println("Location not found")
        }
        if (command == "whereami") {
            println("You are at ${player.location.name}")
        }
        if (command == "look") {
            println("Look for what?")
            var response = readln()
            if (response == "item") {
                for (item in player.location.items) {
                    println("You have found ${item.name}")
                }
            }
            if (response == "people") {
                for (person in player.location.entities) {
                    println("You have found ${person.name}")
                }
            }
        }
        if (command == "inv") {
            for (item in player.inventory) {
                println(item.name)
            }
        }
        if (command == "attack") {
            println("What would you like to use to attack")
            var weapon = readln()
            for (item in player.inventory) {
                if (item.name == weapon) {
                    println("You have that weapon")
                    println("Who would you like to attack?")
                    var attackie = readln()
                    for (person in player.location.entities) {
                        if (person.name == attackie) {
                            println("You have attacked the person")
                            person.health -= 10.0
                            println("Their remaining health is ${person.health}")
                        }
                    }
                    continue@gameloop
                }
            }
        }
    }
}
