package com.example.students_app.model

data class Student(
    val id: String,
    val name: String,
    val phone: String,
    val address: String,
    var isChecked: Boolean,
    val avatarUrl: String
)
