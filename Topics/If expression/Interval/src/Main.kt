fun main() =
    readLine()!!.toInt().run { println(if (this in -14..12 || this in 15..16 || this > 18) "True" else "False") }