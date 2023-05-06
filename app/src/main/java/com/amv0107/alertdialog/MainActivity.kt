package com.amv0107.alertdialog

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.amv0107.alertdialog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btnSuccess.setOnClickListener {
            showSuccessAlertDialog()
        }

        binding.btnWarning.setOnClickListener {
            showWarningAlertDialog()
        }

        binding.btnError.setOnClickListener {
            showErrorAlertDialog()
        }

    }

    private fun showErrorAlertDialog(){
        val builder = AlertDialog.Builder(this, R.style.AlertDialogTheme)
        val view = LayoutInflater.from(this).inflate(
            R.layout.layout_error_dialog,
            findViewById(R.id.layoutDialogContainer)
        )
        builder.setView(view)
        view.findViewById<TextView>(R.id.textTitle).text = "Error Title"
        view.findViewById<TextView>(R.id.textMessage).text = "Whatever msg you want to display"
        view.findViewById<Button>(R.id.buttonAction).text = "Okay"
        view.findViewById<ImageView>(R.id.imageIcon).setImageResource(R.drawable.error)

        val alertDialog = builder.create()
        view.findViewById<Button>(R.id.buttonAction).setOnClickListener {
            alertDialog.dismiss()
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
        }
        if (alertDialog.window != null)
            alertDialog.window!!.setBackgroundDrawable(ColorDrawable(0))
        alertDialog.show()
    }

    private fun showWarningAlertDialog() {
        val builder = AlertDialog.Builder(this, R.style.AlertDialogTheme)
        val view = LayoutInflater.from(this).inflate(
            R.layout.layout_warning_dialog,
            findViewById(R.id.layoutDialogContainer)
        )
        builder.setView(view)
        view.findViewById<TextView>(R.id.textTitle).text = "Warning Title"
        view.findViewById<TextView>(R.id.textMessage).text = "Whatever msg you want to display"
        view.findViewById<Button>(R.id.buttonYes).text = "Yes"
        view.findViewById<Button>(R.id.buttonNo).text = "No"
        view.findViewById<ImageView>(R.id.imageIcon).setImageResource(R.drawable.warning)

        val alertDialog = builder.create()
        view.findViewById<Button>(R.id.buttonYes).setOnClickListener {
            alertDialog.dismiss()
            Toast.makeText(this, "Yes", Toast.LENGTH_SHORT).show()
        }
        view.findViewById<Button>(R.id.buttonNo).setOnClickListener {
            alertDialog.dismiss()
            Toast.makeText(this, "No", Toast.LENGTH_SHORT).show()
        }
        if (alertDialog.window != null)
            alertDialog.window!!.setBackgroundDrawable(ColorDrawable(0))
        alertDialog.show()
    }

    private fun showSuccessAlertDialog() {
        val builder = AlertDialog.Builder(this, R.style.AlertDialogTheme)
        val view = LayoutInflater.from(this).inflate(
            R.layout.layout_success_dialog,
            findViewById(R.id.layoutDialogContainer)
        )
        builder.setView(view)
        view.findViewById<TextView>(R.id.textTitle).text = "Success Title"
        view.findViewById<TextView>(R.id.textMessage).text = "Whatever msg you want to display"
        view.findViewById<Button>(R.id.buttonAction).text = "Okay"
        view.findViewById<ImageView>(R.id.imageIcon).setImageResource(R.drawable.done)

        val alertDialog = builder.create()
        view.findViewById<Button>(R.id.buttonAction).setOnClickListener {
            alertDialog.dismiss()
            Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
        }
        if (alertDialog.window != null)
            alertDialog.window!!.setBackgroundDrawable(ColorDrawable(0))
        alertDialog.show()
    }
}