import online.pizzacrust.kotlinroblox.implementation
import online.pizzacrust.kotlinroblox.jvmimpl.JVMImplementation
import online.pizzacrust.kotlinroblox.std.experimental.CachedPlayer
import online.pizzacrust.kotlinroblox.std.global.StdPlayer
import online.pizzacrust.kotlinroblox.std.global.profile
import org.junit.jupiter.api.Test

class TraditionalVsCacheTests {

    init {
        implementation = JVMImplementation()
    }

    @Test
    fun traditional() {
        val ms = System.currentTimeMillis()
        val player = StdPlayer(profile("TGSCommander")!!)
        for (i in 1..2) {
            player.friends
        }
        println("traditional test took ${System.currentTimeMillis() - ms} ms")
    }

    @Test
    fun modern() {
        val ms = System.currentTimeMillis()
        val player = CachedPlayer(StdPlayer(profile("TGSCommander")!!))
        for (i in 1..2) {
            player.friends
        }
        println("modern test took ${System.currentTimeMillis() - ms} ms")
    }


}