package nl.deltadak.ktemplate

import javafx.scene.control.ProgressIndicator
import junit.framework.TestCase.fail
import org.junit.jupiter.api.Assertions
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.gherkin.Feature
import org.testfx.api.FxToolkit

object JavaFXTestKt : Spek({
    Feature("We can use the JavaFX Toolkit") {
        Scenario("We use the Toolkit") {
            // Initialise JavaFX Toolkit, needed for things like ProgressIndicator.
            FxToolkit.registerPrimaryStage()
            FxToolkit.setupApplication(HelloJavaFX::class.java)
            val helloJavaFX = HelloJavaFX()

            Then("No errors should have been thrown when we instantiate a JavaFX component") {
                val progressIndicator = ProgressIndicator()
                Assertions.assertTrue(helloJavaFX.setLoading(progressIndicator))
            }
        }
    }

    // Spek 1:
//    given("the JavaFX Toolkit") {
//        // Initialise JavaFX Toolkit, needed for things like ProgressIndicator.
//        FxToolkit.registerPrimaryStage()
//        FxToolkit.setupApplication(HelloJavaFX::class.java)
//
//        val helloJavaFX = HelloJavaFX()
//
//        on("instantiating a JavaFX component") {
//            val progressIndicator = ProgressIndicator()
//
//            it("should not throw any errors") {
//                Assertions.assertTrue(helloJavaFX.setLoading(progressIndicator))
//            }
//            it("should fail") {
////                fail("it works!")
//            }
//        }
//
//    }
})
