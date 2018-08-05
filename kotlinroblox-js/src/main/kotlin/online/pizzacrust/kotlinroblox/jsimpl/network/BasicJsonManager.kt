package online.pizzacrust.kotlinroblox.jsimpl.network

import online.pizzacrust.kotlinroblox.network.JsonManager

class BasicJsonManager : JsonManager {
    override fun fromJson(json: String, className: String?): Any {
        return JSON.parse(json)
    }

    override fun toJson(obj: Any): String {
        return JSON.stringify(obj)
    }
}