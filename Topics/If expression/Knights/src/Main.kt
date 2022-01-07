import kotlin.math.abs

fun main() {
    val (x1, y1) = readLine()!!.split(" ").map { it.toInt() }
    val (x2, y2) = readLine()!!.split(" ").map { it.toInt() }
    println(
        when {
            abs(x2 - x1) == 2 && abs(y2 - y1) == 1 -> "YES"
            abs(x2 - x1) == 1 && abs(y2 - y1) == 2 -> "YES"
            else -> "NO"
        }
    )
}