package com.dione.todoapp

import android.os.Bundle
import android.view.View
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager

import kotlinx.android.synthetic.main.activity_history.*
import kotlinx.android.synthetic.main.content_history.*
import java.util.concurrent.ThreadLocalRandom

class HistoryActivity : AppCompatActivity(), ListIntf<TodoModel> {
    override fun <T> listClicked(position: Int, any: Any) {

    }

    lateinit var arrayOfTodo: ArrayList<TodoModel>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setTitle("History")
        arrayOfTodo = ArrayList()
        val randomInteger = ThreadLocalRandom.current().nextInt(1,2)
        for (i in 1..100) {
            arrayOfTodo.add(TodoModel("This is task $i", "dione-$i", randomInteger, 1))
        }

        if (arrayOfTodo.size > 0) {
            rvHistory.apply {
                this.adapter = TodoListAdapter(arrayOfTodo, this@HistoryActivity as ListIntf<TodoModel>)
                this.layoutManager = LinearLayoutManager(this@HistoryActivity)
                this.addItemDecoration(SimpleDividerItemDecoration(this@HistoryActivity))
            }
        } else {
            rvHistory.visibility = View.GONE
            vsNoData.inflate()
        }


    }

    override fun onSupportNavigateUp(): Boolean {
        super.onBackPressed()
        return true
    }

}
