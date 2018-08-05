package online.pizzacrust.kotlinroblox.jsimpl

import online.pizzacrust.kotlinroblox.Implementation
import online.pizzacrust.kotlinroblox.jsimpl.network.BasicJsonManager
import online.pizzacrust.kotlinroblox.jsimpl.network.BasicRequestManager
import online.pizzacrust.kotlinroblox.jsimpl.xml.BasicElement
import online.pizzacrust.kotlinroblox.network.JsonManager
import online.pizzacrust.kotlinroblox.network.RequestsManager
import online.pizzacrust.kotlinroblox.xml.Element
import org.w3c.dom.parsing.DOMParser

val implJsonManager: JsonManager = BasicJsonManager()
val implReqManager: RequestsManager = BasicRequestManager()

class JSImplementation: Implementation {
    override val jsonManager: JsonManager
        get() = implJsonManager
    override val reqManager: RequestsManager
        get() = implReqManager
    override fun parseXml(xml: String): Element {
        val parser = DOMParser()
        return BasicElement(parser.parseFromString(xml, "text/xml"))
    }
}