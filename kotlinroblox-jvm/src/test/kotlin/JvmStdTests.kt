import online.pizzacrust.kotlinroblox.implementation
import online.pizzacrust.kotlinroblox.jvmimpl.JVMImplementation
import online.pizzacrust.kotlinroblox.std.StdPlayer
import online.pizzacrust.kotlinroblox.std.StdProfile
import online.pizzacrust.kotlinroblox.std.profile
import org.junit.jupiter.api.Test

class JvmStdTests {

    init {
        implementation = JVMImplementation()
    }

    @Test
    fun nativeProfileTest() {
        StdProfile("TGSCommander")
    }

    @Test
    fun nativePlayerTest() {
        StdPlayer(StdProfile("TGSCommander"))
    }

    @Test
    fun childrenPlayerTest() {
        val player = StdPlayer(StdProfile("TGSCommander"))
        //println(player.pastUsernames)
        println(player.friends.size)
        //println(player.club.name)
    }

}