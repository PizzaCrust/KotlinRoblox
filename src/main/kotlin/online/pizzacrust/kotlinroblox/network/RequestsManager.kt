package online.pizzacrust.kotlinroblox.network

import java.util.*

interface RequestsManager {

    fun get(url: String, headers: () -> Map<String, String> = { HashMap() }): RequestResponse

    fun post(url: String, fieldData: () -> Map<String, String> = { HashMap() }, headers: () ->
    Map<String,
            String> = { HashMap() }):
            RequestResponse

}