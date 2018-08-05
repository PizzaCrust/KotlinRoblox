package online.pizzacrust.kotlinroblox.xml

import java.util.*

interface HasChildren {

    val elements: List<Element>

    fun elementsByClass(className: String): List<Element> {
        val list: MutableList<Element> = ArrayList()
        for (element in elements) {
            if (element.className == className) {
                list.add(element)
            }
        }
        return list
    }

    fun elementsByTag(tagName: String): List<Element> {
        val list: MutableList<Element> = ArrayList()
        for (element in elements) {
            if (element.tagName == tagName) {
                list.add(element)
            }
        }
        return list
    }

}