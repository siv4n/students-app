package com.example.students_app

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.students_app.model.Model

class StudentDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_details)

        // Enable back button in action bar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Student Details"

        val studentId = intent.getStringExtra("student_id")
        val student = studentId?.let { Model.shared.getStudent(it) }

        if (student != null) {
            findViewById<TextView>(R.id.details_student_name).text = "Name: ${student.name}"
            findViewById<TextView>(R.id.details_student_id).text = "ID: ${student.id}"
            findViewById<TextView>(R.id.details_student_phone).text = "Phone: ${student.phone}"
            findViewById<TextView>(R.id.details_student_address).text = "Address: ${student.address}"
            findViewById<CheckBox>(R.id.details_student_check).isChecked = student.isChecked
        }

        findViewById<Button>(R.id.details_edit_button).setOnClickListener {
            // TODO: Implement Edit screen navigation
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
