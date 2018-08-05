package online.pizzacrust.kotlinroblox.jvmimpl.network

import com.mashape.unirest.http.Unirest
import online.pizzacrust.kotlinroblox.network.RequestResponse
import online.pizzacrust.kotlinroblox.network.RequestsManager

class BasicRequestManager : RequestsManager {
    override fun get(url: String, headers: () -> Map<String, String>): RequestResponse {
        val response =  Unirest.get(url).headers(headers()).asString()
        return RequestResponse(response.body, response.headers.toMap())
    }

    override fun post(url: String, fieldData: () -> Map<String, String>, headers: () -> Map<String,
            String>): RequestResponse {
        val response = Unirest.post(url).headers(headers()).fields(fieldData()).asString()
        return RequestResponse(response.body, response.headers.toMap())
    }
}