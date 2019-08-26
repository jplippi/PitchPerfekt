package model

class Entity {
    val damageDone: Long = 0
    val damageTaken: Long = 0

    val stats = Stats()
    val statuses = emptyList<Status>()

    fun getModifiedStats(): Stats {
        return Stats(stats).apply {
            statuses.forEach {
                this + it.modifiers
            }
        }
    }
}