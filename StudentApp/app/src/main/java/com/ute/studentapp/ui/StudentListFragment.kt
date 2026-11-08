package com.ute.studentapp.ui


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ute.studentapp.R
import com.ute.studentapp.model.Student

class StudentListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_student_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewStudents)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Danh sách sinh viên mẫu (có thông tin của bạn)
        val studentList = listOf(
            Student("2415053122208", "Lê Thế Duy", "CNTT / Kỹ thuật Phần mềm", "theduy@ute.udn.vn", "0900000000"),
            Student("22505120002", "Nguyễn Văn A", "22CT111", "a.nv@ute.udn.vn", "0911111111"),
            Student("22505120003", "Trần Thị B", "22CT112", "b.tt@ute.udn.vn", "0922222222")
        )

        val adapter = StudentAdapter(studentList) { student ->
            // Chuyển sang StudentDetailFragment khi click vào dòng
            val detailFragment = StudentDetailFragment().apply {
                arguments = Bundle().apply {
                    putParcelable("student_data", student)
                }
            }
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, detailFragment)
                .addToBackStack(null)
                .commit()
        }

        recyclerView.adapter = adapter
    }
}