package online.pizzacrust.kotlinroblox.jsimpl.xml

import online.pizzacrust.kotlinroblox.xml.Element
import org.w3c.dom.Node
import org.w3c.dom.asList
import kotlin.dom.isElement

class BasicElement(val element: Node): Element {

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
        if (element.isElement) {
            return (element as org.w3c.dom.Element).getAttribute(attributeName)
        }
        return null
    }

    override val tagName: String
        get() {
            if (element.isElement) {
                return (element as org.w3c.dom.Element).tagName
            }
            throw RuntimeException("Is not a JS XML element!")
        }

    override val text: String?
        get() {
            if (element.isElement) {
                return (element as org.w3c.dom.Element).textContent
            }
            throw RuntimeException("Is not a JS XML element!")
        }
}