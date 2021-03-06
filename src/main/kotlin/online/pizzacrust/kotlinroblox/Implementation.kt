package online.pizzacrust.kotlinroblox

import online.pizzacrust.kotlinroblox.network.JsonManager
import online.pizzacrust.kotlinroblox.network.RequestsManager
import online.pizzacrust.kotlinroblox.network.SchedulingManager
import online.pizzacrust.kotlinroblox.xml.Element

interface Implementation {

    val jsonManager: JsonManager

    val reqManager: RequestsManager

    fun parseXml(xml: String): Element

    val schedulingManager: SchedulingManager

}

lateinit var implementation: Implementation