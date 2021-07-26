package com.jhonjto.data.service.response

data class Claims(
    val excluded: ExcludedX? = null,
    val period: String? = null,
    val rate: Double? = null,
    val value: Int? = null
)