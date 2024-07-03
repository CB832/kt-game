class Location (
    var name: String,
    var description: String,
    var entities: MutableSet<Entity>,
    var items: MutableSet<Item>,
    var destinations: MutableSet<Location>
)

