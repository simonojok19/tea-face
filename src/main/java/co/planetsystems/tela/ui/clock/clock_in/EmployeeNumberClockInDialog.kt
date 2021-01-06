package co.planetsystems.tela.ui.clock.clock_in

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import co.planetsystems.tela.R

class EmployeeNumberClockInDialog: DialogFragment() {


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            // Get the layout inflater
            val view = requireActivity().layoutInflater.inflate(R.layout.passcode_clock_in_layout, null)

            view.findViewById<EditText>(R.id.enrollment_id)

            // Inflate and set the layout for the dialog
            // Pass null as the parent view because its going in the dialog layout
            builder.setView(view)
                    // Add action buttons
                    .setPositiveButton(R.string.clock_in,
                            DialogInterface.OnClickListener { dialog, id ->
                                Log.d("TAG", id.toString())
                            })
                    .setNegativeButton(R.string.cancel,
                            DialogInterface.OnClickListener { dialog, id ->
                                getDialog()?.cancel()
                            })
                    .setCancelable(true)
            builder.create()


        } ?: throw IllegalStateException("Activity cannot be null")
    }

    override fun toString(): String {
        return super<DialogFragment>.toString()
    }

    override fun onCancel(dialog: DialogInterface) {
        super.onCancel(dialog)
    }

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
    }
}