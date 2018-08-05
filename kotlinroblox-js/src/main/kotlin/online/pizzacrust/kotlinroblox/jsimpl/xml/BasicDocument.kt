package online.pizzacrust.kotlinroblox.jsimpl.xml

import online.pizzacrust.kotlinroblox.xml.Element
import org.w3c.dom.Document
import org.w3c.dom.asList
import kotlin.dom.isElement

class BasicDocument(val doc: Document): online.pizzacrust.kotlinroblox.xml.Document {
    override val elements: List<Element>
        get() {
            val elements: MutableList<Element> = ArrayList()
            for (node in doc.childNodes.asList()) {
                if (node.isElement) {
                    elements.add(BasicElement(node as org.w3c.dom.Element))
                }
            }
            return elements
        }
}