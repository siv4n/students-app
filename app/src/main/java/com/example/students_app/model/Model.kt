package com.example.students_app.model

class Model private constructor() {

    private val students: MutableList<Student> = ArrayList()

    companion object {
        val shared = Model()
    }

    /**
     * Get all students
     */
    fun getAllStudents(): List<Student> {
        return students
    }

    /**
     * Add a student
     */
    fun addStudent(student: Student) {
        students.add(student)
    }

    /**
     * Get a student by ID
     */
    fun getStudent(id: String): Student? {
        return students.find { it.id == id }
    }

    /**
     * Update a student
     */
    fun updateStudent(newStudent: Student) {
        val index = students.indexOfFirst { it.id == newStudent.id }
        if (index != -1) {
            students[index] = newStudent
        }
    }

    /**
     * Delete a student
     */
    fun deleteStudent(student: Student) {
        students.remove(student)
    }
}
