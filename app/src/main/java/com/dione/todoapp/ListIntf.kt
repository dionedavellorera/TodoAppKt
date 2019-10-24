package com.dione.todoapp

interface ListIntf<out T> {
    fun <T> listClicked(position: Int)
}