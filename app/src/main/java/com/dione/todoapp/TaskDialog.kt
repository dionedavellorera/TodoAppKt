package com.dione.todoapp

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.dialog_task.*

abstract class TaskDialog(context: Context) : Dialog(context) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_task)
        setCancelable(false)
        initViews()
    }

    private fun initViews() {
        confirm.setOnClickListener{
            confirm("dione dave")
            dismiss()
        }
        cancel.setOnClickListener{
            close()
            dismiss()
        }
    }


    abstract fun confirm(string: String)
    abstract fun close()

}