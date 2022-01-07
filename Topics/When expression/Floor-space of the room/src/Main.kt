import kotlin.math.pow

const val PI = 3.14
fun main() {
    when (readLine()!!) {
        "triangle" -> {
            val (a, b, c) = DoubleArray(3) { readLine()!!.toDouble() }
            val p = (a + b + c) / 2
            println((p * (p - a) * (p - b) * (p - c)).pow(0.5))
        }
        "rectangle" -> println(readLine()!!.toDouble() * readLine()!!.toDouble())
        "circle" -> println(readLine()!!.toDouble().pow(2) * PI)
    }
}