package online.pizzacrust.kotlinroblox.xml

interface HasChildren {

    val elements: List<Element>

    fun elementsByClass(className: String): List<Element> {
        val list: MutableList<Element> = ArrayList()
        for (element in elements) {
            if (element.className?.contains(className, ignoreCase = true) ?: false) {
                list.add(element)
            }
            list.addAll(element.elementsByClass(className))
        }
        return list
    }

    fun elementsByTag(tagName: String): List<Element> {
        val list: MutableList<Element> = ArrayList()
        for (element in elements) {
            if (element.tagName == tagName) {
                list.add(element)
            }
            list.addAll(element.elementsByTag(tagName))
        }
        return list
    }

}