package online.pizzacrust.kotlinroblox.api

interface Profile {

    val id: Long

    val username: String

    val profileUrl: String
        get() = "https://www.roblox.com/users/$id/profile"

}