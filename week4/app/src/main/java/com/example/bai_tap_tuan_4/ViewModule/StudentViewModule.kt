package com.example.bai_tap_tuan_4.ViewModule

import androidx.lifecycle.ViewModel
import com.example.bai_tap_tuan_4.Entity.Student

class StudentViewModule : ViewModel() {
    var studentList = mutableListOf<Student>()
    fun addStudent(student: Student){
        studentList.add(student)
    }

}