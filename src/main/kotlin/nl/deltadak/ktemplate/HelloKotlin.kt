package nl.deltadak.ktemplate

/**
 * Default Hello class.
 */
class HelloKotlin {

    /**
     * Find out what 1+1 is.
     * @return 1+1
     */
    fun calculate(): Int {
        return 1 + (
            listOf(
                0,
                0,
                1
            ).maxOrNull() ?: 0
            )
    }

    fun unused() = 2
}

/**
 * Run HelloKotlin.
 */
fun main() {
    println(HelloKotlin().calculate())
}
