fun main() = println(
    when (readLine()!!.toInt()) {
        2 -> "Yes!"
        1, 3, 4 -> "No!"
        else -> "Unknown number"
    })