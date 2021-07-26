package com.jhonjto.data.service.response

data class Transactions(
    val canceled: Int? = null,
    val completed: Int? = null,
    val period: String? = null,
    val ratings: Ratings? = null,
    val total: Int? = null
)