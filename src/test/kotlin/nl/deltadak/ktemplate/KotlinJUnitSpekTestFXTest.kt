package nl.deltadak.ktemplate

import javafx.scene.control.ProgressIndicator
import junit.framework.TestCase.fail
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.junit.jupiter.api.Assertions
import org.testfx.api.FxToolkit

object JavaFXTestKt : Spek({
    given("the JavaFX Toolkit") {
        // Initialise JavaFX Toolkit, needed for things like ProgressIndicator.
        FxToolkit.registerPrimaryStage()
        FxToolkit.setupApplication(HelloJavaFX::class.java)

        val helloJavaFX = HelloJavaFX()

        on("instantiating a JavaFX component") {
            val progressIndicator = ProgressIndicator()

            it("should not throw any errors") {
                Assertions.assertTrue(helloJavaFX.setLoading(progressIndicator))
            }
            it("should fail") {
                fail("it works!")
            }
        }

    }
})
