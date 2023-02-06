package nl.deltadak.ktemplate

interface FormattingTest {
    fun myFun(): String {
        processValues(null, { file, value ->
            // code here
            true
        }, everythingScope("blub"))

        return "the blubs"
    } // closes myFun

    // Dummy functions in FormattingTest
    fun processValues(first: String?, second: (String, String) -> Boolean, last: String) {
        // ...
    }

    fun everythingScope(value: String) = value
}
