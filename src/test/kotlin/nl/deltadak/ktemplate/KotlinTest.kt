@file:Suppress("MemberVisibilityCanBePrivate")

package nl.deltadak.ktemplate

import io.kotlintest.equalityMatcher
import io.kotlintest.matchers.exactly
import io.kotlintest.matchers.shouldBe
import io.kotlintest.should
import io.kotlintest.shouldBe
import io.kotlintest.specs.FunSpec

class KotlinTest: FunSpec() {

    init {
        testCalculate()
    }

    /** With kotlintest 3.0.2, this test is also run! Hooray! */
    fun testCalculate() = test("one plus one is two") {
        HelloKotlin().calculate().toDouble() shouldBe 2.0
    }

}