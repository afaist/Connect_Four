fun main() = Array(2) { readLine()!!.toBigInteger() }.run {
    println((this[0] + this[1] + (this[0] - this[1]).abs()) / 2.toBigInteger())
}