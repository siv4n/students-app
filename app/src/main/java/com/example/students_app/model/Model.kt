package com.example.students_app.model

class Model private constructor() {

    private val students: MutableList<Student> = ArrayList()

    companion object {
        val shared = Model()
    }

    init {
        students.add(Student(
            id = "0",
            name = "Amit",
            phone = "054-7654321",
            address = "Rishon LeZion",
            isChecked = true,
            avatarUrl = ""
        ))

        students.add(Student(
            id = "1",
            name = "Sivan",
            phone = "052-1111111",
            address = "Herzliya",
            isChecked = false,
            avatarUrl = ""
        ))
    }

    fun getAllStudents(): List<Student> {
        return students
    }

    fun addStudent(student: Student) {
        students.add(student)
    }

    fun deleteStudent(student: Student) {
        students.remove(student)
    }

    fun getStudent(id: String): Student? {
        return students.find { it.id == id }
    }

    fun updateStudent(newStudent: Student) {
        val index = students.indexOfFirst { it.id == newStudent.id }
        if (index != -1) {
            students[index] = newStudent
        }
    }
}