@file:Suppress("MemberVisibilityCanBePrivate")

package nl.deltadak.ktemplate

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.doubles.plusOrMinus
import io.kotest.matchers.shouldBe

class KotlinTest : FunSpec() {

    init {
        testCalculate()
    }

    /** With kotlintest 3.0.2, this test is also run! Hooray! */
    fun testCalculate() = test("one plus one is two") {
        HelloKotlin().calculate().toDouble() shouldBe (2.0 plusOrMinus 0.42)
    }
}
