package nl.deltadak.ktemplate

import org.junit.jupiter.api.Assertions.assertEquals
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.gherkin.Feature

object KotlinJUnitSpekTest : Spek({
    Feature("Empty feature") {
        Scenario("Nothing is given") {
            val something = emptyList<Nothing>()
            var nothingness = -42 // todo not so nice, see spekframework/spek#448
            Given("Nothing holds") {
                something.isEmpty()
            }
            When("Doing nothing") {
                nothingness = something.size
            }
            Then("It should not be") {
                assertEquals(nothingness, 0)
            }
//            Then("It should fail") {
//                fail("it works!")
//            }
        }
    }
})
