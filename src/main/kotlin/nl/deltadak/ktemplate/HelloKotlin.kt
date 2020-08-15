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
        return 1 + 1
    }
}

/**
 * Run HelloKotlin.
 */
fun main() {
    println(HelloKotlin().calculate())
}
