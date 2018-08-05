package online.pizzacrust.kotlinroblox.std

import online.pizzacrust.kotlinroblox.api.Profile
import online.pizzacrust.kotlinroblox.implementation

fun profile(username: String): Profile? {
    return try {
        StdProfile(username)
    } catch (e: RuntimeException) {
        null
    }
}

fun profile(userId: Long): Profile? {
    return try {
        StdProfile(userId)
    } catch (e: RuntimeException) {
        null
    }
}

class StdProfile : Profile {

    private val internalId: Long
    private val internalUsername: String

    data class UsernameToIdResponse(var userId: Long?, var username: String?) {
        constructor(): this(null, null)
    }

    internal constructor(id: Long, username: String) {
        this.internalId = id
        this.internalUsername = username
    }

    @Deprecated("Do not use this without catching it.")
    constructor(username: String) {
        val url = "http://api.roblox.com/users/get-by-username?username=$username"
        val responseText = implementation.reqManager.get(url).response
        val parsed: UsernameToIdResponse = implementation.jsonManager.fromJson(responseText,
                UsernameToIdResponse()) as UsernameToIdResponse
        this.internalId = parsed.userId ?: throw RuntimeException("invalid username")
        this.internalUsername = username
    }

    @Deprecated("Do not use this without catching it.")
    constructor(id: Long) {
        val url = "http://api.roblox.com/users/$id"
        val responseText = implementation.reqManager.get(url).response
        val parsed: UsernameToIdResponse = implementation.jsonManager.fromJson(responseText,
                UsernameToIdResponse()) as UsernameToIdResponse
        this.internalUsername = parsed.username ?: throw RuntimeException("invalid id")
        this.internalId = id
    }

    override val id: Long
        get() = internalId
    override val username: String
        get() = internalUsername
}