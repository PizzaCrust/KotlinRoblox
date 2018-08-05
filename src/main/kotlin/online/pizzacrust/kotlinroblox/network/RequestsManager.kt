package online.pizzacrust.kotlinroblox.network

interface RequestsManager {

    fun get(url: String, headers: () -> Map<String, String> = { HashMap() }): RequestResponse

    fun post(url: String, fieldData: () -> Map<String, String> = { HashMap() }, headers: () ->
    Map<String,
            String> = { HashMap() }):
            RequestResponse

}