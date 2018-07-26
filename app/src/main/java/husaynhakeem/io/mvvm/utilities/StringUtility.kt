package husaynhakeem.io.mvvm.utilities


object StringUtility {

    fun stringFromNumbers(vararg numbers: Int): String {
        val sNumbers = StringBuilder()
        for (number in numbers)
            sNumbers.append(number)
        return sNumbers.toString()
    }
}
