package online.pizzacrust.kotlinroblox.xml

interface Element: HasChildren {

    fun attribute(attributeName: String): String?

    val className: String?
        get() = attribute("class")

    val tagName: String

    val text: String?

}