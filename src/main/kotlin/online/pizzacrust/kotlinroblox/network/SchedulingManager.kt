package online.pizzacrust.kotlinroblox.network

interface SchedulingManager {

    fun repeatSchedule(timeInMs: Int, block: () -> Unit)

    fun delaySchedule(timeInMs: Int, block: () -> Unit)

}