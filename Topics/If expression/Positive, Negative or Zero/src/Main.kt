fun main() {
    // write your code here
    val n = readLine()!!.toInt()
    println(if (n == 0) "zero" else if (n > 0) "positive" else "negative")
}