package com.example.students_app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.students_app.model.Model
import com.example.students_app.model.Student

class EditStudentActivity : AppCompatActivity() {

    private var studentId: String? = null
    private var originalStudent: Student? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_student)

        studentId = intent.getStringExtra("student_id")
        originalStudent = studentId?.let { Model.shared.getStudent(it) }

        val nameEditText = findViewById<EditText>(R.id.edit_student_name)
        val idEditText = findViewById<EditText>(R.id.edit_student_id)
        val phoneEditText = findViewById<EditText>(R.id.edit_student_phone)
        val addressEditText = findViewById<EditText>(R.id.edit_student_address)
        val checkBox = findViewById<CheckBox>(R.id.check_student_status)
        val saveButton = findViewById<Button>(R.id.button_save)
        val cancelButton = findViewById<Button>(R.id.button_cancel)
        val deleteButton = findViewById<Button>(R.id.button_delete)

        if (originalStudent != null) {
            nameEditText.setText(originalStudent?.name)
            idEditText.setText(originalStudent?.id)
            phoneEditText.setText(originalStudent?.phone)
            addressEditText.setText(originalStudent?.address)
            checkBox.isChecked = originalStudent?.isChecked == true
        }

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
                avatarUrl = originalStudent?.avatarUrl ?: ""
            )

            if (originalStudent != null) {
                if (originalStudent?.id == id) {
                    Model.shared.updateStudent(newStudent)
                } else {
                    Model.shared.deleteStudent(originalStudent!!)
                    Model.shared.addStudent(newStudent)
                }
            }
            finish()
        }

        cancelButton.setOnClickListener {
            finish()
        }

        deleteButton.setOnClickListener {
            originalStudent?.let { Model.shared.deleteStudent(it) }
            finish()
        }
    }
}
