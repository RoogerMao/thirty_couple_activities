package com.example.a30days.data

import androidx.compose.runtime.MutableState

data class CoupleActivity(
    val stringID: Int,
    val descriptionID: Int,
    val imageID: Int,
    var expanded: MutableState<Boolean>
)
