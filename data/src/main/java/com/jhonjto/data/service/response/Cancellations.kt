package com.jhonjto.data.service.response

data class Cancellations(
    val excluded: Excluded? = null,
    val period: String? = null,
    val rate: Double? = null,
    val value: Int? = null
)