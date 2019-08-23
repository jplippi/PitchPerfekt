import model.Entity
import model.Event

fun process() {
    val player = Entity()
    val target = Entity()
    val events: List<Event>

    events.forEach {
        it.process(player, target)
    }
}