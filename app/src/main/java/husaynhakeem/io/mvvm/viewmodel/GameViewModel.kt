package husaynhakeem.io.mvvm.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableArrayMap

import husaynhakeem.io.mvvm.model.Cell
import husaynhakeem.io.mvvm.model.Game
import husaynhakeem.io.mvvm.model.Player

import husaynhakeem.io.mvvm.utilities.StringUtility.stringFromNumbers

class GameViewModel : ViewModel() {

    lateinit var cells: ObservableArrayMap<String, String>
    private var game: Game? = null

    val winner: LiveData<Player>
        get() = game?.winner!!

    fun init(player1: String, player2: String) {
        game = null
        game = Game(player1, player2)
        cells = ObservableArrayMap()
    }

    fun onClickedCellAt(row: Int, column: Int) {
        game?.let {
            it.cells?.let {
                if (it[row][column] == null) {
                    it[row][column] = Cell(game?.currentPlayer)
                    cells[stringFromNumbers(row, column)] = game?.currentPlayer?.value
                    if (game?.hasGameEnded() == true)
                        game?.reset()
                    else
                        game?.switchPlayer()
                }

            }
        }
    }
}
