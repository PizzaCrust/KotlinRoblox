package online.pizzacrust.kotlinroblox.network

interface JsonManager {

    fun toJson(obj: Any): String

    fun fromJson(json: String, className: Any? = null) : Any

}