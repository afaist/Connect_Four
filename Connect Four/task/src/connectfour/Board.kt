package connectfour

const val FIRST_MARK = 'o'
const val SECOND_MARK = '*'
const val WIN_CHAIN = 4
const val START_CHECK = (WIN_CHAIN - 1) * 2

class Board(private val rows: Int, private val columns: Int) {
    private var board = Array(columns) { Array(rows) { ' ' } }
    private lateinit var firstPlayer: Player
    private lateinit var secondPlayer: Player
    private var fullColumns = mutableListOf<Int>()
    fun setPlayers(_firstPlayer: Player, _secondPlayer: Player) {
        this.firstPlayer = _firstPlayer
        this.secondPlayer = _secondPlayer
    }

    /**
     * Play game
     *
     * @param player
     */
    fun play(player: Player = firstPlayer) {
        board = Array(columns) { Array(rows) { ' ' } }
        fullColumns.clear()
        var numberMoves = 0
        println(this)
        var currentPlayer = player
        while (true) {
            println("${currentPlayer.name}'s turn:")
            val input = readLine()!!
            if (input == "end") {
                break
            }
            if (!input.matches("\\d+".toRegex())) {
                println("Incorrect column number")
                continue
            }
            val move = input.toInt()
            if (move !in 1..columns) {
                println("The column number is out of range (1 - $columns)")
                continue
            }
            if (move in fullColumns) {
                println("Column $move is full")
                continue
            }
            val row = board[move - 1].indexOfFirst { it == ' ' }
            board[move - 1][row] = currentPlayer.mark
            if (row == rows - 1) {
                fullColumns.add(move)
            }
            println(this)
            if (++numberMoves > START_CHECK) {
                when (status(move - 1, row, currentPlayer.mark)) {
                    Status.WIN -> {
                        println("Player ${currentPlayer.name} won")
                        currentPlayer.points += 2
                        break
                    }
                    Status.DRAW -> {
                        println("It is a draw")
                        firstPlayer.points++
                        secondPlayer.points++
                        break
                    }
                    Status.CONTINUE -> {
                    }
                }
            }
            currentPlayer = if (currentPlayer == firstPlayer) {
                secondPlayer
            } else {
                firstPlayer
            }
        }

    }

    /**
     * Check status
     *
     * @param column
     * @param row
     * @param mark
     * @return
     */
    private fun status(column: Int, row: Int, mark: Char): Status {
        val winRow = mark.toString().repeat(WIN_CHAIN)
        // Check column
        if (board[column].joinToString("").contains(winRow)) {
            return Status.WIN
        }
        // Check row
        val rowFill = Array(columns) { ' ' }
        for (i in 0 until columns) {
            rowFill[i] = board[i][row]
        }
        if (rowFill.joinToString("").contains(winRow)) {
            return Status.WIN
        }
        // Check diagonals
        val diagonal1 = mutableListOf<Char>()
        val diagonal2 = mutableListOf<Char>()
        var sum = column + row
        var start = if (sum < columns) 0 else sum - column + 1
        var end = if (sum < rows) sum else sum - rows + 1
        if (end - start > 2) {
            for (i in start..end) {
                diagonal1.add(board[i][sum - i])
            }
            if (diagonal1.joinToString("").contains(winRow)) {
                return Status.WIN
            }
        }
        sum = column - row
        start = if (sum <= 0) 0 else sum
        end = rows - 1 + sum
        if (end - start > 2) {
            if (end >= columns) {
                end = columns - 1
            }
            for (i in start..end) {
                diagonal2.add(board[i][i - start])
            }
            if (diagonal2.joinToString("").contains(winRow)) {
                return Status.WIN
            }
        }
        if (fullColumns.size == columns) {
            return Status.DRAW
        }
        return Status.CONTINUE
    }

    /**
     * Print board
     *
     * @return
     */
    override fun toString(): String {
        val str = StringBuilder()
        str.append(" ")
        str.append((1..columns).joinToString(" "))
        str.append("\n")
        for (j in rows - 1 downTo 0) {
            str.append("║")
            for (i in 0 until columns) {
                str.append(board[i][j])
                str.append("║")
            }
            str.append("\n")
        }
        str.append("╚")
        str.append(Array(columns) { '═' }.joinToString("╩"))
        str.append("╝")
        return str.toString()
    }
}