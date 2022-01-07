fun main() {
    // write your code here
    val (a, b, c) = IntArray(3) { readLine()!!.toInt() }
    println(
        if (a + b > c && b + c > a && c + a > b) {
            "YES"
        } else {
            "NO"
        }
    )
}