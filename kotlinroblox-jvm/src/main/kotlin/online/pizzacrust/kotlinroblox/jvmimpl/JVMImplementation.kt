package online.pizzacrust.kotlinroblox.jvmimpl

import online.pizzacrust.kotlinroblox.Implementation
import online.pizzacrust.kotlinroblox.jvmimpl.network.BasicJsonManager
import online.pizzacrust.kotlinroblox.jvmimpl.network.BasicRequestManager
import online.pizzacrust.kotlinroblox.jvmimpl.xml.BasicElement
import online.pizzacrust.kotlinroblox.network.JsonManager
import online.pizzacrust.kotlinroblox.network.RequestsManager
import online.pizzacrust.kotlinroblox.xml.Element
import org.jsoup.Jsoup

val implJsonManager: JsonManager = BasicJsonManager()
val implReqManager: RequestsManager = BasicRequestManager()

class JVMImplementation: Implementation {
    override val jsonManager: JsonManager
        get() = implJsonManager
    override val reqManager: RequestsManager
        get() = implReqManager
    override fun parseXml(xml: String): Element {
        return BasicElement(Jsoup.parse(xml))
    }
}