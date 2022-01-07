const val FOUR = 4
fun main() {
    val (a, b, c, d) = Array(FOUR) { readLine()!! }.map { it.toBigInteger() }
    println(-a * b + c - d)
}