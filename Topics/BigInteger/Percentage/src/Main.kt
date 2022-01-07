fun main() = Array(2) { readLine()!!.toBigInteger() }.run {
    val s = this.sumOf { it }
    print("${this[0] * "100".toBigInteger() / s}% ${this[1] * "100".toBigInteger() / s}%")
}