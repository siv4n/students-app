package com.example.students_app.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.students_app.R
import com.example.students_app.model.Student

class StudentsAdapter(var students: List<Student>? = null) : RecyclerView.Adapter<StudentsAdapter.StudentViewHolder>() {

    var listener: OnItemClickListener? = null

    interface OnItemClickListener {
        fun onItemClick(student: Student)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.student_name)
        val idTextView: TextView = itemView.findViewById(R.id.student_id)
        val checkBox: CheckBox = itemView.findViewById(R.id.student_check_box)
        val studentImage: ImageView = itemView.findViewById(R.id.student_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.student_list_row, parent, false)
        return StudentViewHolder(view)
    }

    override fun getItemCount(): Int {
        return students?.size ?: 0
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = students?.get(position)
        student?.let {
            holder.nameTextView.text = it.name
            holder.idTextView.text = it.id
            holder.checkBox.setOnCheckedChangeListener(null) // Clear listener to avoid recycling issues
            holder.checkBox.isChecked = it.isChecked
            
            holder.checkBox.setOnCheckedChangeListener { _, isChecked ->
                it.isChecked = isChecked
            }

            holder.itemView.setOnClickListener {
                listener?.onItemClick(student)
            }
        }
    }
}
