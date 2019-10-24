package com.dione.todoapp

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item_todo_list.view.*

class TodoListAdapter(private val todoList : List<TodoModel>, val listIntf: ListIntf<TodoModel>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    companion object {
        private val TYPE_NORMAL = 100
        private val TYPE_URGENT = 200
    }

    init {

    }

    class CustomViewHolder(view: View, mListIntf: ListIntf<TodoModel>) : RecyclerView.ViewHolder(view), UpdateViewHolder{
        private var taskName : TextView
        private var listIntf = mListIntf
        init {
            taskName = view.findViewById(R.id.listTaskName)
        }
        override fun bindViews(todoModel: TodoModel, position: Int) {
            taskName.text = todoModel.taskName
            taskName.setOnClickListener {
                listIntf.listClicked<TodoModel>(position)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val viewHolder: RecyclerView.ViewHolder = when (viewType) {
            TYPE_NORMAL -> CustomViewHolder(parent.inflate(R.layout.list_item_todo_list, parent, false), listIntf)
            else -> CustomViewHolder(parent.inflate(R.layout.list_item_todo_list, parent, false), listIntf)
        }
        return viewHolder
    }

    override fun getItemCount(): Int {
        return todoList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as CustomViewHolder).bindViews(todoList[holder.adapterPosition], holder.adapterPosition)
    }

    override fun getItemViewType(position: Int): Int {
        return todoList.get(position).viewType
    }


}