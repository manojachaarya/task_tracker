package com.example.task_tracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var todoadapter: ToDoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        todoadapter = ToDoAdapter(mutableListOf())

        val rvTodoItems : RecyclerView = findViewById(R.id.rvToDoItems)
        rvTodoItems.adapter = todoadapter
        rvTodoItems.layoutManager = LinearLayoutManager(this)

        val btnAddTodo : Button = findViewById(R.id.btnAddTodo)
        val etTodoTitle : EditText = findViewById(R.id.etToDoTittle)
        btnAddTodo.setOnClickListener {
            val todoTitle = etTodoTitle.text.toString()
            if(todoTitle.isNotEmpty()) {
                val todo = ToDo(todoTitle)
                todoadapter.addTodo(todo)
                etTodoTitle.text.clear()
            }
        }
        val btnDeleteDoneTools : Button = findViewById(R.id.btnDeleteDoneTodos)
        btnDeleteDoneTools.setOnClickListener {
           todoadapter.deleteDoneTodos()
        }


        rvTodoItems.adapter = todoadapter
    }
}