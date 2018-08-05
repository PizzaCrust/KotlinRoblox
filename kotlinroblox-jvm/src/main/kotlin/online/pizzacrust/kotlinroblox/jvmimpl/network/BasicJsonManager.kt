package online.pizzacrust.kotlinroblox.jvmimpl.network

import com.google.gson.Gson
import online.pizzacrust.kotlinroblox.network.JsonManager

class BasicJsonManager : JsonManager {
    override fun toJson(obj: Any): String {
        return Gson().toJson(obj)
    }

    override fun fromJson(json: String, className: Any?): Any {
        if (className == null) throw RuntimeException("Class name is required on the JVM!")
        return Gson().fromJson(json, className.javaClass)
    }
}