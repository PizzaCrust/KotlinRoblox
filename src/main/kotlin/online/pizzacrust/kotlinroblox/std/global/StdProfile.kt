package online.pizzacrust.kotlinroblox.std.global

import online.pizzacrust.kotlinroblox.api.global.Profile
import online.pizzacrust.kotlinroblox.implementation

private val cachedProfiles: MutableList<Profile> = mutableListOf()

fun profile(username: String): Profile? {
    for (cachedProfile in cachedProfiles) {
        if (cachedProfile.username == username) {
            return cachedProfile
        }
    }
    return try {
        StdProfile(username)
    } catch (e: RuntimeException) {
        null
    }
}

fun profile(userId: Long): Profile? {
    for (cachedProfile in cachedProfiles) {
        if (cachedProfile.id == userId) {
            return cachedProfile
        }
    }
    return try {
        StdProfile(userId)
    } catch (e: RuntimeException) {
        null
    }
}

class StdProfile : Profile {

    private val internalId: Long
    private val internalUsername: String

    data class UsernameToIdResponse(var Id: Long?, var Username: String?) {
        constructor() : this(null, null)
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
        this.internalId = parsed.Id ?: throw RuntimeException("invalid username")
        this.internalUsername = username
    }

    @Deprecated("Do not use this without catching it.")
    constructor(id: Long) {
        val url = "http://api.roblox.com/users/$id"
        val responseText = implementation.reqManager.get(url).response
        val parsed: UsernameToIdResponse = implementation.jsonManager.fromJson(responseText,
                UsernameToIdResponse()) as UsernameToIdResponse
        this.internalUsername = parsed.Username ?: throw RuntimeException("invalid id")
        this.internalId = id
    }

    override val id: Long
        get() = internalId
    override val username: String
        get() = internalUsername
}