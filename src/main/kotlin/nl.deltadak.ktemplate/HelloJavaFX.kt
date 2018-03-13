package nl.deltadak.ktemplate

import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.ProgressIndicator
import javafx.scene.control.Spinner
import javafx.scene.layout.StackPane
import javafx.stage.Stage

/**
 * Sample class to show JavaFX.
 */
class HelloJavaFX : Application() {
    /** height  */
    private val height = 250
    /** width  */
    private val width = 300

    /**
     * Start the application
     */
    override fun start(primaryStage: Stage) {
        primaryStage.title = "Hello World!"
        val btn = Button()
        btn.text = "Say 1+1"
        btn.setOnAction { _ -> println(calculate()) }

        val spinner = Spinner<Int>()

        val root = StackPane()
        root.children.add(btn)
        root.children.add(spinner)
        primaryStage.scene = Scene(root, width.toDouble(), height.toDouble())
        primaryStage.show()
    }

    /**
     * Show 1+1.
     * @return 1+1
     */
    fun calculate(): Int {
        return 1 + 1
    }

    /**
     * Indicate something is loading.
     *
     * @param progressIndicator User wants feedback.
     *
     * @return Whether the progress was succesfully set.
     */
    fun setLoading(progressIndicator: ProgressIndicator): Boolean {
        progressIndicator.isVisible = true
        return true
    }

    /**
     * Start application.
     */
    fun main(args: Array<String>) {
        Application.launch(*args)
    }

}

/**
 * Main method.
 * @param args Default
 */
fun main(args: Array<String>) {
    HelloJavaFX().main(args)
}
