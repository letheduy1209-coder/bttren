package com.ute.studentapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.ute.studentapp.R
import com.ute.studentapp.model.Student

class StudentDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_student_detail, container, false)    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvName = view.findViewById<TextView>(R.id.tvStudentName)
        val tvId = view.findViewById<TextView>(R.id.tvStudentId)
        val tvClass = view.findViewById<TextView>(R.id.tvStudentClass)
        val tvEmail = view.findViewById<TextView>(R.id.tvStudentEmail)

        // Nhận dữ liệu truyền qua Bundle
        val student = arguments?.getParcelable<Student>("student_data")
        student?.let {
            tvName.text = "Họ tên: ${it.name}"
            tvId.text = "Mã sinh viên: ${it.id}"
            tvClass.text = "Lớp: ${it.className}"
            tvEmail.text = "Email: ${it.email}"
        }
    }
}