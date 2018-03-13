@file:Suppress("MemberVisibilityCanBePrivate")

package nl.deltadak.ktemplate

import io.kotlintest.KTestJUnitRunner
import io.kotlintest.matchers.exactly
import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.FunSpec
import org.junit.runner.RunWith

@RunWith(KTestJUnitRunner::class)
class KotlinTest: FunSpec() {

    init {
        testCalculate()
    }

    /** Test will not be run using Gradle when also JUnit 5 is used. */
    fun testCalculate() = test("one plus one is two") {
        HelloKotlin().calculate() shouldBe exactly(42.0)
    }

}