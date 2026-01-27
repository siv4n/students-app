package com.example.students_app

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.students_app.model.Model
import com.example.students_app.model.Student

class NewStudentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_student)

        val nameEditText = findViewById<EditText>(R.id.edit_student_name)
        val idEditText = findViewById<EditText>(R.id.edit_student_id)
        val phoneEditText = findViewById<EditText>(R.id.edit_student_phone)
        val addressEditText = findViewById<EditText>(R.id.edit_student_address)
        val checkBox = findViewById<CheckBox>(R.id.check_student_status)
        val saveButton = findViewById<Button>(R.id.button_save)
        val cancelButton = findViewById<Button>(R.id.button_cancel)

        saveButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val id = idEditText.text.toString()
            val phone = phoneEditText.text.toString()
            val address = addressEditText.text.toString()
            val isChecked = checkBox.isChecked

            val newStudent = Student(
                id = id,
                name = name,
                phone = phone,
                address = address,
                isChecked = isChecked,
                avatarUrl = ""
            )

            Model.shared.addStudent(newStudent)
            finish()
        }

        cancelButton.setOnClickListener {
            finish()
        }
    }
}
