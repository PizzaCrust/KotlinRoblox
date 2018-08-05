package online.pizzacrust.kotlinroblox.api

enum class Club {
    NONE,
    CLASSIC,
    TURBO,
    OUTRAGEOUS,
}

/**
 * Still work in progress.
 */
interface Player: Profile {

    val pastUsernames: List<String>

    val friends: List<Profile>

    val club: Club

}