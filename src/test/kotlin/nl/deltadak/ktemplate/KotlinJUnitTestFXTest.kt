package nl.deltadak.ktemplate


import javafx.scene.control.ProgressIndicator
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Test
import org.testfx.api.FxRobot
import org.testfx.api.FxToolkit

import java.util.concurrent.TimeoutException

import org.junit.jupiter.api.Assertions.assertTrue

/**
 * Test general JavaFX components.
 */
class KotlinJUnitTestFXTest : FxRobot() {

    /**
     * Tests that testing JavaFX components works.
     *
     * @throws TimeoutException When initialising JavaFX times out.
     */
    @Test
    @Throws(TimeoutException::class)
    fun testProgress() {
        // Initialise JavaFX.
        FxToolkit.registerPrimaryStage()
        FxToolkit.setupApplication(HelloJavaFX::class.java)

        val helloJavaFX = HelloJavaFX()

        val progressIndicator = ProgressIndicator()

        assertTrue(helloJavaFX.setLoading(progressIndicator))

    }

}