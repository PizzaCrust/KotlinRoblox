package online.pizzacrust.kotlinroblox.jsimpl.network

import online.pizzacrust.kotlinroblox.network.SchedulingManager
import kotlin.browser.window

class BasicSchedulingManager: SchedulingManager {
    override fun repeatSchedule(timeInMs: Int, block: () -> Unit) {
        window.setInterval(block, timeInMs)
    }

    override fun delaySchedule(timeInMs: Int, block: () -> Unit) {
        window.setTimeout(block, timeInMs)
    }
}