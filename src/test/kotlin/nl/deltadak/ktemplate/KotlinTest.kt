@file:Suppress("MemberVisibilityCanBePrivate")

package nl.deltadak.ktemplate

import io.kotlintest.matchers.exactly
import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.FunSpec

class KotlinTest: FunSpec() {

    init {
        testCalculate()
    }

    fun testCalculate() = test("one plus one is two") {
        HelloKotlin().calculate() shouldBe exactly(3.0)
    }

}