package com.example.students_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.students_app.adapter.StudentsAdapter
import com.example.students_app.model.Model

class StudentsListActivity : AppCompatActivity() {

    private var studentsRecyclerView: RecyclerView? = null
    private var adapter: StudentsAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_students_list)

        studentsRecyclerView = findViewById(R.id.students_recycler_view)
        studentsRecyclerView?.setHasFixedSize(true)
        studentsRecyclerView?.layoutManager = LinearLayoutManager(this)
        
        adapter = StudentsAdapter(Model.shared.getAllStudents())
        studentsRecyclerView?.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        adapter?.students = Model.shared.getAllStudents()
        adapter?.notifyDataSetChanged()
    }
}
