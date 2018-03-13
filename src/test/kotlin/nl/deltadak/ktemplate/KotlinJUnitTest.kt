package nl.deltadak.ktemplate

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KotlinJUnitTest {

    @Test
    fun testKotlinJUnit() {
        val helloWorld = HelloKotlin()
        assertEquals(2, helloWorld.calculate(), "message")
    }

}
