import online.pizzacrust.kotlinroblox.implementation
import online.pizzacrust.kotlinroblox.jvmimpl.JVMImplementation
import org.jsoup.Jsoup
import org.junit.jupiter.api.Test

class XmlTests {

    init {
        implementation = JVMImplementation()
    }

    @Test
    fun elementChildren() {
        val element = implementation.parseXml(implementation.reqManager.get("https://example.org")
                .response)
        val jsoupElement = Jsoup.connect("https://example.org").get()
        assert(jsoupElement.children().size == element.elements.size)
    }

    @Test
    fun descriptionTest() {
        val element = implementation.parseXml(implementation.reqManager.get("https://www.roblox" +
                ".com/users/38043848/profile").response)
        val text = element.elementsByClass("profile-about-content-text").first().text
        println(text)
        assert(text?.isEmpty() ?: false)
    }

}