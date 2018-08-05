package online.pizzacrust.kotlinroblox.jvmimpl.xml

import online.pizzacrust.kotlinroblox.xml.Element

class BasicElement(val element: org.jsoup.nodes.Element): Element {
    override fun attribute(attributeName: String): String? {
        return element.attr(attributeName)
    }
    override val tagName: String
        get() = element.tagName()
    override val text: String?
        get() = element.text()
    override val elements: List<Element>
        get() {
            val elements: MutableList<Element> = ArrayList()
            for (child in element.children()) {
                elements.add(BasicElement(child))
            }
            return elements
        }
}