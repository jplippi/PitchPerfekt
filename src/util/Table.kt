package util

open class Table<K1, K2, V> {
    private val map = HashMap<K1, HashMap<K2, V>>()

    operator fun get(key1: K1, key2: K2): V {
        return map[key1]?.get(key2) ?: throw NoSuchElementException()
    }

    operator fun set(key1: K1, key2: K2, value: V) {
        (map[key1] ?: HashMap()).apply {
            set(key2,value)
            map[key1] = this
        }
    }
}