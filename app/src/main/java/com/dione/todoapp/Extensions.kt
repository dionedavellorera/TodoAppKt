package com.dione.todoapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes

fun ViewGroup.inflate(@LayoutRes layoutRes: Int, viewGroup: ViewGroup,attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutRes, viewGroup, attachToRoot)
}
