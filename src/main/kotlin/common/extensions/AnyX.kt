package common.extensions

fun Any.id(): Int {
    return hashCode()
}