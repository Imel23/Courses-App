package com.example.coursesapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val topicTitleResourceId: Int,
    val numberOfCourses: Int,
    @DrawableRes val imageResourceId: Int
)
