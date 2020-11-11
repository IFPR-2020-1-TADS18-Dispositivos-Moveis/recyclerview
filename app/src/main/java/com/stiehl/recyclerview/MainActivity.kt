package com.stiehl.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.stiehl.recyclerview.adapters.PersonAdapter
import com.stiehl.recyclerview.models.Person
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var adapter: PersonAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = PersonAdapter()
        listPeople.adapter = adapter
        listPeople.layoutManager = LinearLayoutManager(
            this, LinearLayoutManager.VERTICAL, false
        )

        btAdd.setOnClickListener {
            val newPerson = Person("Dom", "Pedro", "Imperador")
            adapter.add(newPerson)
        }
    }
}