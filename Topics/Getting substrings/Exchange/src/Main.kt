fun main() =
    print(readLine()!!.run {
        this.last() + this.drop(1).dropLast(1) + this.first()
    })