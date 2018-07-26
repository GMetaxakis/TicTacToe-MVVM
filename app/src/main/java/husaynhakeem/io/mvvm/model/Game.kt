package husaynhakeem.io.mvvm.model


import android.arch.lifecycle.MutableLiveData

class Game(playerOne: String, playerTwo: String) {

    var player1: Player? = null
    var player2: Player? = null

    var currentPlayer = player1

    var cells: Array<Array<Cell?>>? = null

    var winner = MutableLiveData<Player>()

    val isBoardFull: Boolean
        get() {
            cells?.let {
                for (row in it)
                    for (cell in row)
                        if (cell == null || cell.isEmpty)
                            return false
            }
            return true
        }

    init {
        player1 = Player(playerOne, "x")
        player2 = Player(playerTwo, "o")
        currentPlayer = player1
        cells = Array(BOARD_SIZE) { arrayOfNulls<Cell?>(BOARD_SIZE) }
    }

    fun hasGameEnded(): Boolean {
        if (hasThreeSameHorizontalCells() || hasThreeSameVerticalCells() || hasThreeSameDiagonalCells()) {
            winner.value = currentPlayer
            return true
        }

        if (isBoardFull) {
            winner.value = null
            return true
        }

        return false
    }

    fun hasThreeSameHorizontalCells(): Boolean {
        try {
            cells?.let {
                for (i in 0 until BOARD_SIZE)
                    if (areEqual(it[i][0], it[i][1], it[i][2]))
                        return true
            }
            return false
        } catch (e: NullPointerException) {
            return false
        }

    }

    fun hasThreeSameVerticalCells(): Boolean {
        try {
            cells?.let {
                for (i in 0 until BOARD_SIZE)
                    if (areEqual(it[0][i], it[1][i], it[2][i]))
                        return true
            }
            return false
        } catch (e: NullPointerException) {
            return false
        }
    }

    fun hasThreeSameDiagonalCells(): Boolean {
        return try {
            cells?.let {
                areEqual(it[0][0], it[1][1], it[2][2]) || areEqual(it[0][2], it[1][1], it[2][0])
            } == true
        } catch (e: NullPointerException) {
            false
        }
    }

    /**
     * 2 cells are equal if:
     * - Both are none null
     * - Both have non null values
     * - both have equal values
     *
     * @param cells: Cells to check if are equal
     * @return
     */
    private fun areEqual(vararg cells: Cell?): Boolean {
        for (cell in cells)
            if (cell == null || cell.player?.value.isNullOrEmpty())
                return false

        val comparisonBase = cells[0]
        for (i in 1 until cells.size)
            if (comparisonBase?.player?.value != cells[i]?.player?.value)
                return false

        return true
    }

    fun switchPlayer() {
        currentPlayer = if (currentPlayer === player1) player2 else player1
    }

    fun reset() {
        player1 = null
        player2 = null
        currentPlayer = null
        cells = null
    }

    companion object {
        private const val BOARD_SIZE: Int = 3
    }
}
