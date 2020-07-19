package husaynhakeem.io.mvvm.view

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.databinding.DataBindingUtil
import android.os.Bundle
import androidx.annotation.VisibleForTesting
import androidx.appcompat.app.AppCompatActivity
import husaynhakeem.io.mvvm.R
import husaynhakeem.io.mvvm.databinding.ActivityGameBinding
import husaynhakeem.io.mvvm.model.Player
import husaynhakeem.io.mvvm.viewmodel.GameViewModel

private const val GAME_BEGIN_DIALOG_TAG = "game_dialog_tag"
private const val GAME_END_DIALOG_TAG = "game_end_dialog_tag"
private const val NO_WINNER = "No one"

class GameActivity : AppCompatActivity() {

    private lateinit var gameViewModel: GameViewModel
    private lateinit var activityGameBinding: ActivityGameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        promptForPlayers()
    }

    fun promptForPlayers() {
        GameBeginDialog.newInstance(this).apply {
            isCancelable = false
            show(supportFragmentManager, GAME_BEGIN_DIALOG_TAG)
        }
    }

    fun onPlayersSet(player1: String, player2: String) {
        initDataBinding()
        initViewModel(player1, player2)
    }

    private fun initDataBinding() {
        activityGameBinding = DataBindingUtil.setContentView(this, R.layout.activity_game)
    }

    private fun initViewModel(player1: String, player2: String) {
        gameViewModel = ViewModelProviders.of(this).get(GameViewModel::class.java)
        gameViewModel.init(player1, player2)
        gameViewModel.winner.observe(this, Observer { this.onGameWinnerChanged(it) })
        activityGameBinding.gameViewModel = gameViewModel
    }

    @VisibleForTesting
    fun onGameWinnerChanged(winner: Player?) {
        val winnerName = if (winner == null || winner.name.isEmpty()) NO_WINNER else winner.name
        GameEndDialog.newInstance(this, winnerName).apply {
            isCancelable = false
            show(supportFragmentManager, GAME_END_DIALOG_TAG)
        }
    }
}
