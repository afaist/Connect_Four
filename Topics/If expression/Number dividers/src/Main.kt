fun main() = readLine()!!.toInt().run {
    listOf(2, 3, 5, 6).forEach { if (this % it == 0) println("Divided by $it") }
}
