package extensions

fun Long.toSeconds(): Double {
    return this / 1000.0
}

fun Double.toMilli(): Long {
    return (this * 1000).toLong()
}
