package com.dione.todoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.ThreadLocalRandom

class MainActivity : AppCompatActivity(), ListIntf<TodoModel>, View.OnClickListener {
    override fun onClick(p0: View?) {
        when(p0!!.id) {
            R.id.fabAddTask -> {
                val taskDialog = object: TaskDialog(this@MainActivity) {
                    override fun confirm(string: String) {
                        println(string)
                    }

                    override fun close() {
                        println("closed")
                    }

                }

                taskDialog.show()
            }
            else -> ""
        }
    }


    lateinit var arrayOfTodo: ArrayList<TodoModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setTitle("Tasks")
        initViews()
        arrayOfTodo = ArrayList<TodoModel>()

        val randomInteger = ThreadLocalRandom.current().nextInt(1,2)
        for (i in 1..100) {
            arrayOfTodo.add(TodoModel("This is task $i", "dione-$i", randomInteger, 1))
        }

        if (arrayOfTodo.size > 0) {
            rvTodoList.apply {
                this.adapter = TodoListAdapter(arrayOfTodo, this@MainActivity as ListIntf<TodoModel>)
                this.layoutManager = LinearLayoutManager(this@MainActivity)
                this.addItemDecoration(SimpleDividerItemDecoration(this@MainActivity))
            }
        } else {
            rvTodoList.visibility = View.GONE
            vsNoData.inflate()
        }

    }


    private fun initViews() {
        fabAddTask.setOnClickListener(this@MainActivity)
    }

    override fun <T> listClicked(position: Int, any: Any) {
        var obj:TodoModel = any as TodoModel
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main_activity, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.menuHistory -> {
                startActivity(Intent(this@MainActivity, HistoryActivity::class.java))
            }
            else -> return super.onOptionsItemSelected(item)
        }
        return true
    }
}
