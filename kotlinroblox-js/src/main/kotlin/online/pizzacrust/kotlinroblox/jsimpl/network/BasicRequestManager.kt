package online.pizzacrust.kotlinroblox.jsimpl.network

import online.pizzacrust.kotlinroblox.network.RequestResponse
import online.pizzacrust.kotlinroblox.network.RequestsManager
import org.w3c.xhr.FormData
import org.w3c.xhr.XMLHttpRequest

class BasicRequestManager: RequestsManager {
    private fun parseHeaders(string: String): Map<String, List<String>> {
        val lineSplit = string.trim().split("\\r?\\n")
        val map: MutableMap<String, List<String>> = HashMap()
        lineSplit.forEach {
            val split = it.split(":")
            val headerName = split[0]
            val underlings: MutableList<String> = ArrayList()
            split[1].split(";").forEachIndexed {
                i, o ->
                if (i > 0) {
                    underlings.add(o.trim())
                }
            }
            if (underlings.size == 0) {
                underlings.add(split[1])
            }
            map[headerName] = underlings
        }
        return map
    }

    override fun get(url: String, headers: () -> Map<String, String>): RequestResponse {
        val req = XMLHttpRequest()
        headers().forEach {
            req.setRequestHeader(it.key, it.value)
        }
        req.open("GET", url)
        return RequestResponse(req.responseText, parseHeaders(req.getAllResponseHeaders()))
    }

    override fun post(url: String, fieldData: () -> Map<String, String>, headers: () -> Map<String, String>): RequestResponse {
        val req = XMLHttpRequest()
        headers().forEach {
            req.setRequestHeader(it.key, it.value)
        }
        val formData = FormData()
        fieldData().forEach {
            formData.append(it.key, it.value)
        }
        req.open("POST", url)
        if (!fieldData().keys.isEmpty()) {
            req.send(formData)
        }
        return RequestResponse(req.responseText, parseHeaders(req.getAllResponseHeaders()))
    }
}