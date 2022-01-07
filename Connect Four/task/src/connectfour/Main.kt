package connectfour

fun main() {
    println("Connect Four")
    println("First player's name:")
    val firstPlayerName = readLine()!!
    println("Second player's name:")
    val secondPlayerName = readLine()!!
    var boardSize = listOf(6, 7)
    while (true) {
        println("Set the board dimensions (Rows x Columns)\n" +
                "Press Enter for default (6 x 7)")
        val input = readLine()!!
        if (input.isNotEmpty()) {
            try {
                boardSize = input.lowercase()
                    .replace("\\s".toRegex(), "")
                    .split("x")
                    .map { it.toInt() }
                if (boardSize[0] !in 5..9) {
                    println("Board rows should be from 5 to 9")
                    continue
                }
                if (boardSize[1] !in 5..9) {
                    println("Board columns should be from 5 to 9")
                    continue
                }
                break
            } catch (e: Exception) {
                println("Invalid input")
            }
        } else {
            break
        }
    }
    var games = 1
    while (true) {
        println("Do you want to play single or multiple games?\n" +
                "For a single game, input 1 or press Enter\n" +
                "Input a number of games:")
        val input = readLine()!!
        if (input.isEmpty()) {
            break
        }
        if (!input.matches("\\d+".toRegex())) {
            println("Invalid input")
            continue
        }
        if (input.toInt() < 1) {
            println("Invalid input")
            continue
        }
        games = input.toInt()
        break
    }
    println("$firstPlayerName VS $secondPlayerName")
    println("${boardSize[0]} X ${boardSize[1]} board")
    val board = Board(boardSize[0], boardSize[1])
    val firstPlayer = Player(firstPlayerName, FIRST_MARK)
    val secondPlayer = Player(secondPlayerName, SECOND_MARK)
    board.setPlayers(firstPlayer, secondPlayer)
    if (games == 1) {
        println("Single game")
        board.play()
    } else {
        println("Total $games games")
        var currentPlayer = firstPlayer
        for (i in 1..games) {
            println("Game #$i")
            board.play(currentPlayer)
            println("Score")
            println("$firstPlayerName: ${firstPlayer.points} $secondPlayerName: ${secondPlayer.points}")
            currentPlayer = if (currentPlayer == firstPlayer) {
                secondPlayer
            } else {
                firstPlayer
            }
        }
    }
    println("Game over!")
}