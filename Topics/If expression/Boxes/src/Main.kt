fun main() {
    val (x1, y1, z1) = readLine()!!.split(" ").map { it.toInt() }.sorted()
    val (x2, y2, z2) = readLine()!!.split(" ").map { it.toInt() }.sorted()
    println(
        if (x1 == x2 && y1 == y2 && z1 == z2) {
            "Box 1 = Box 2"
        } else if (x1 <= x2 && y1 <= y2 && z1 <= z2) {
            "Box 1 < Box 2"
        } else if (x1 >= x2 && y1 >= y2 && z1 >= z2) {
            "Box 1 > Box 2"
        } else {
            "Incomparable"
        }
    )
}