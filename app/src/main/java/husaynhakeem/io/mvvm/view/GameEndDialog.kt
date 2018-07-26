package husaynhakeem.io.mvvm.view


import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v7.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView

import husaynhakeem.io.mvvm.R

class GameEndDialog : DialogFragment() {

    private var rootView: View? = null
    private lateinit var activity: GameActivity
    private var winnerName: String? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        initViews()
        val alertDialog = AlertDialog.Builder(context!!)
                .setView(rootView)
                .setCancelable(false)
                .setPositiveButton(R.string.done) { _, _ -> onNewGame() }
                .create()
        alertDialog.setCanceledOnTouchOutside(false)
        alertDialog.setCancelable(false)
        return alertDialog
    }

    private fun initViews() {
        rootView = LayoutInflater.from(context).inflate(R.layout.game_end_dialog, null, false)
        (rootView?.findViewById<View>(R.id.tv_winner) as TextView?)?.text = winnerName
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
