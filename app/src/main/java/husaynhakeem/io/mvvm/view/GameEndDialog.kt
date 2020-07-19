package husaynhakeem.io.mvvm.view


import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.appcompat.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView

import husaynhakeem.io.mvvm.R

class GameEndDialog : androidx.fragment.app.DialogFragment() {

    private lateinit var rootView: View
    private lateinit var activity: GameActivity
    private var winnerName: String? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        initViews()
        return AlertDialog.Builder(rootView.context)
                .setView(rootView)
                .setCancelable(false)
                .setCancelable(false)
                .setPositiveButton(R.string.done) { _, _ -> onNewGame() }
                .create().apply {
                    setCanceledOnTouchOutside(false)
                    setCancelable(false)
                }
    }

    private fun initViews() {
        rootView = LayoutInflater.from(context).inflate(R.layout.game_end_dialog, null, false)
        rootView.findViewById<TextView>(R.id.tv_winner).text = winnerName
    }

    private fun onNewGame() {
        dismiss()
        activity.promptForPlayers()
    }

    companion object {

        fun newInstance(activity: GameActivity, winnerName: String): GameEndDialog {
            val dialog = GameEndDialog()
            dialog.activity = activity
            dialog.winnerName = winnerName
            return dialog
        }
    }
}
