package com.ute.studentapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Student(
    val id: String,
    val name: String,
    val className: String,
    val email: String,
    val phone: String
) : Parcelable