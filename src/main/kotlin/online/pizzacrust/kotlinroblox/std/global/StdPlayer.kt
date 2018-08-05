package online.pizzacrust.kotlinroblox.std

import online.pizzacrust.kotlinroblox.api.Club
import online.pizzacrust.kotlinroblox.api.Player
import online.pizzacrust.kotlinroblox.api.Profile
import online.pizzacrust.kotlinroblox.implementation
import online.pizzacrust.kotlinroblox.xml.Element

fun player(username: String): StdPlayer? {
    val profile = profile(username)
    return if (profile == null) {
        null
    } else {
        StdPlayer(profile)
    }
}

fun player(userId: Long): StdPlayer? {
    val profile = profile(userId)
    return if (profile == null) {
        null
    } else {
        StdPlayer(profile)
    }
}

class StdPlayer(profile: Profile): Player, Profile by profile {

    val cachedProfile: Element = implementation.parseXml(implementation.reqManager.get(profileUrl).response)

    override val pastUsernames: List<String>
        get() {
            val names = ArrayList<String>()
            val rootNode1 = cachedProfile.elementsByClass("profile-name-history")
            if (!rootNode1.isEmpty()) {
                val rootNode = rootNode1.first()
                val pastNamesElement = rootNode.elementsByClass("tooltip-pastnames").first()
                val pastNamesUnparsed = pastNamesElement.attribute("title")
                val splitted = pastNamesUnparsed!!.split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
                for (s in splitted) {
                    names.add(s.trim())
                }
            }
            return names
        }

    data class FriendData(var UserId: Long?, var Username: String?) {
        constructor() : this(null, null)
    }

    data class FriendResponse(var Friends: Array<FriendData?>?) {
        constructor(): this(null)
    }

    override val friends: List<Profile>
        get() {
            val references = ArrayList<Profile>()
            val url = "https://www.roblox" +
                    ".com/friends/json?userId=$id&currentPage=0&pageSize=1000&imgWidth=110" +
                    "&imgHeight=110&imgFormat=jpeg&friendsType" +
                    "=BestFriends"
            val response = implementation.jsonManager.fromJson(implementation.reqManager.get(url)
                    .response, FriendResponse()) as FriendResponse
            for (friend in response.Friends ?: throw RuntimeException("Friends is null")) {
                if (friend?.UserId != null && friend.Username != null) {
                    references.add(StdProfile(friend.UserId!!, friend.Username!!))
                }
            }
            return references
        }

    override val club: Club
        get() {
            val root = cachedProfile.elementsByClass("profile-header-top").first()
            val topPart = root.elementsByClass("header-title").first()
            val bc = topPart.elementsByTag("span")
            if (bc.isEmpty()) {
                return Club.NONE
            }
            val bcType = bc.first().className
            if (bcType.equals("icon-bc", ignoreCase = true)) {
                return Club.CLASSIC
            }
            return if (bcType.equals("icon-tbc", ignoreCase = true)) {
                Club.TURBO
            } else Club.OUTRAGEOUS
        }
}