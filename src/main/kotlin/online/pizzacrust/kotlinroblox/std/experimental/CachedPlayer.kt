package online.pizzacrust.kotlinroblox.std.experimental

import online.pizzacrust.kotlinroblox.api.global.Club
import online.pizzacrust.kotlinroblox.api.global.Player
import online.pizzacrust.kotlinroblox.api.global.Profile
import online.pizzacrust.kotlinroblox.std.global.StdPlayer
import online.pizzacrust.kotlinroblox.std.global.profile

private val cachedPlayers: MutableList<CachedPlayer> = mutableListOf()

fun cachedPlayer(userId: Long): CachedPlayer? {
    for (cachedPlayer in cachedPlayers) {
        if (cachedPlayer.id == userId) {
            return cachedPlayer
        }
    }
    return try {
        CachedPlayer(StdPlayer(profile(userId) ?: throw RuntimeException()))
    } catch (e: RuntimeException) {
        null
    }
}

fun cachedPlayer(username: String): CachedPlayer? {
    for (cachedPlayer in cachedPlayers) {
        if (cachedPlayer.username == username) {
            return cachedPlayer
        }
    }
    return try {
        CachedPlayer(StdPlayer(profile(username) ?: throw RuntimeException()))
    } catch (e: RuntimeException) {
        null
    }
}

class CachedPlayer internal constructor(private val handle: Player): Player, CachedDelegate
("CachedPlayer") {
    override val pastUsernames: List<String>
        get() = cache("pastUsernames") {
            handle.pastUsernames
        }
    override val friends: List<Profile>
        get() = cache("friends") {
            handle.friends
        }
    override val club: Club
        get() = cache("club") {
            handle.club
        }
    override val id: Long
        get() = cache("id") {
            handle.id
        }
    override val username: String
        get() = cache("username") {
            handle.username
        }
}