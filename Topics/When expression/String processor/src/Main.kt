const val EQUALS = "equals"
const val PLUS = "plus"
const val ENDS_WITH = "endsWith"
const val THREE = 3
fun main() {
    val (f, op, s) = Array<String>(THREE) { readLine()!! }
    println(
        when (op) {
            EQUALS -> f == s
            PLUS -> f + s
            ENDS_WITH -> f.endsWith(s)
            else -> "Unknown operation"
        }
    )
}