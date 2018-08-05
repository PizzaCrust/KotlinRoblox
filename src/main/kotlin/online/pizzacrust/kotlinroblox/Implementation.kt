package online.pizzacrust.kotlinroblox

import online.pizzacrust.kotlinroblox.network.JsonManager
import online.pizzacrust.kotlinroblox.network.RequestsManager
import online.pizzacrust.kotlinroblox.xml.Document

interface Implementation {

    val jsonManager: JsonManager

    val reqManager: RequestsManager

    fun parseXml(xml: String): Document

}

lateinit var implementation: Implementation