package online.pizzacrust.kotlinroblox.std

import online.pizzacrust.kotlinroblox.api.Profile
import online.pizzacrust.kotlinroblox.implementation

fun profile(username: String): Profile? {
    try {
        return StdProfile(username)
    } catch (e: RuntimeException) {
        return null
    }
}

class StdProfile @Deprecated("Do not use this without catching it.") constructor(username: String) : Profile {

    private val internalId: Long
    private val internalUsername: String = username

    data class UsernameToIdResponse(var userId: Long?) {
        constructor(): this(null)
    }

    init {
        val url = "http://api.roblox.com/users/get-by-username?username=$username"
        val responseText = implementation.reqManager.get(url).response
        val parsed: UsernameToIdResponse = implementation.jsonManager.fromJson(responseText,
                UsernameToIdResponse()) as UsernameToIdResponse
        this.internalId = parsed.userId ?: throw RuntimeException("invalid username")
    }

    override val id: Long
        get() = internalId
    override val username: String
        get() = internalUsername
}