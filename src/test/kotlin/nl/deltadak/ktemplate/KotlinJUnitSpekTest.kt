package nl.deltadak.ktemplate

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.fail

object KotlinJUnitSpekTest: Spek({
    given("nothing") {
        val something = emptyList<Nothing>()
        on("doing nothing") {
            val nothingness = something.size
            it("should not be") {
                assertEquals(nothingness, 0)
            }
//            it("should fail") {
//                fail("it works!")
//            }
        }
    }
})