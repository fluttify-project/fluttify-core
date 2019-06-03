package task

abstract class Task<T, R>(input: T) {
    abstract fun process(): R
}