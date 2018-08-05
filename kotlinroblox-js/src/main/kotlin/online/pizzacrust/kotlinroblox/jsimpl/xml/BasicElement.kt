package online.pizzacrust.kotlinroblox.jsimpl.xml

import online.pizzacrust.kotlinroblox.xml.Element
import org.w3c.dom.asList
import kotlin.dom.isElement

class BasicElement(val element: org.w3c.dom.Element): Element {

    override val elements: List<Element>
        get() {
            val elements: MutableList<Element> = ArrayList()
            for (node in element.childNodes.asList()) {
                if (node.isElement) {
                    elements.add(BasicElement(node as org.w3c.dom.Element))
                }
            }
            return elements
        }

    override fun attribute(attributeName: String): String? {
        return element.getAttribute(attributeName)
    }

    override val tagName: String
        get() = element.tagName

    override val text: String?
        get() = element.textContent
}