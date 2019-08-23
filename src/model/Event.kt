package model

abstract class Event(
    val timestamp: Long
) {
    abstract fun process(source: Entity, target: Entity)
}