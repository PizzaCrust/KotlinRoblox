package online.pizzacrust.kotlinroblox.network

interface RequestsManager {

    fun get(url: String, headers: () -> Map<String, String>): RequestResponse

    fun post(url: String, fieldData: () -> Map<String, String>, headers: () -> Map<String, String>):
            RequestResponse

}