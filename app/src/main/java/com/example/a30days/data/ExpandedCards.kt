package com.example.a30days.data

data class ExpandedCards(
    val expandedCards: MutableList<Boolean> = MutableList(30) { false }
)
