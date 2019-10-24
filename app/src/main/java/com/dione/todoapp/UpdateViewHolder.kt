package com.dione.todoapp

interface UpdateViewHolder {
    fun bindViews(todoModel: TodoModel, position: Int)
}