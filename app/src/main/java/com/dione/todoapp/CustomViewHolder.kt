package com.dione.todoapp

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer

class CustomViewHolder(view: View, mListIntf: ListIntf<TodoModel>) :
    RecyclerView.ViewHolder(view), UpdateViewHolder{


    private var taskName : TextView
    private var listIntf = mListIntf

    init {
        taskName = view.findViewById(R.id.listTaskName)
    }

    override fun bindViews(anyModel: Any, position: Int) {
        val mModel = anyModel as TodoModel
        taskName.text = mModel.taskName
        taskName.setOnClickListener {
            listIntf.listClicked<TodoModel>(position, mModel)
        }
    }
}