package online.pizzacrust.kotlinroblox.jvmimpl.network

import online.pizzacrust.kotlinroblox.network.SchedulingManager
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.TimeUnit

class BasicSchedulingManager: SchedulingManager {

    private val scheduledService: ScheduledExecutorService = Executors.newScheduledThreadPool(5)

    override fun repeatSchedule(timeInMs: Int, block: () -> Unit) {
        scheduledService.scheduleAtFixedRate({
            block()
        }, 0, timeInMs.toLong(), TimeUnit.MILLISECONDS)
    }

    override fun delaySchedule(timeInMs: Int, block: () -> Unit) {
        scheduledService.schedule({
            block()
        }, timeInMs.toLong(), TimeUnit.MILLISECONDS)
    }
}