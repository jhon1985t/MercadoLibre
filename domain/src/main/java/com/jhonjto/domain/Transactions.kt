package com.jhonjto.domain

data class Transactions(
    val canceled: Int? = null,
    val completed: Int? = null,
    val period: String? = null,
    val ratings: Ratings? = null,
    val total: Int? = null
)