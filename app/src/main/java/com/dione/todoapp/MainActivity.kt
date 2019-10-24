package com.dione.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.ThreadLocalRandom

class MainActivity : AppCompatActivity(), ListIntf<TodoModel> {
    lateinit var arrayOfTodo: ArrayList<TodoModel>




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        arrayOfTodo = ArrayList<TodoModel>()

        val randomInteger = ThreadLocalRandom.current().nextInt(1,2)
        for (i in 1..100) {
            arrayOfTodo.add(TodoModel(" FisadsajdsalkdjsakldjsalkdjsakldjsaljdsalkdjasljFisadsajdsalkdjsakldjsalkdjsakldjsaljdsalkdjasljxFisadsajdsalkdjsakldjsalkdjsakldjsaljdsalkdjasljx FisadsajdsalkdjsakldjsalkdjsakldjsaljdsalkdjasljxxFisadsajdsalkdjsakldjsalkdjsakldjsaljdsalkdjasljx bed $i", "dione-$i", randomInteger, 1))
        }

        rvTodoList.apply {
            this.adapter = TodoListAdapter(arrayOfTodo, this@MainActivity as ListIntf<TodoModel>)
            this.layoutManager = LinearLayoutManager(this@MainActivity)
            this.addItemDecoration(SimpleDividerItemDecoration(this@MainActivity))
        }
    }

    override fun <T> listClicked(position: Int) {
        Log.d("MYDATA22", arrayOfTodo.get(position).taskName)
    }
}
