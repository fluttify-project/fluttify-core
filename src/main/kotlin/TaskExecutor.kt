import task.Task

object TaskExecutor {

    var artifact: Any? = null

    @Suppress("UNCHECKED_CAST")
    fun <T, R> exec(doTask: (artifact: T) -> Task<T, R>): TaskExecutor {
        return apply { artifact = doTask(artifact as T).process() }
    }

}