package online.pizzacrust.kotlinroblox.api

enum class Club {
    NONE,
    BUILDERS,
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