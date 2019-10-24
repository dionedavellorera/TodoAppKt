package com.dione.todoapp

data class TodoModel(
    var taskName: String, var username: String,
    var viewType: Int, var status: Int)