package online.pizzacrust.kotlinroblox.std.experimental

private val cacheMap: MutableMap<CacheIdentifier, Any> = mutableMapOf()

data class CacheIdentifier(val parentId: String, val id: String)

@Suppress("UNCHECKED_CAST")
fun <RETURN_TYPE_CACHE> cache(id: CacheIdentifier, block: () -> RETURN_TYPE_CACHE? = {null}):
        RETURN_TYPE_CACHE {
    if (cacheMap.containsKey(id)) {
        return cacheMap[id] as RETURN_TYPE_CACHE
    }
    val obj = block() ?: throw RuntimeException("Block is supposed to return a proper value")
    cacheMap[id] = obj as Any
    return obj
}

open class CachedDelegate(val name: String) {

    fun <R_CACHE> cache(id: String, block: () -> R_CACHE? = {null}): R_CACHE {
        return cache(CacheIdentifier(name, id), block)
    }

}