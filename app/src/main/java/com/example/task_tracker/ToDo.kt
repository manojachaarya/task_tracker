package com.example.task_tracker

import android.icu.text.CaseMap.Title

data class ToDo (
    val title: String,
    var isChecked: Boolean = false
)