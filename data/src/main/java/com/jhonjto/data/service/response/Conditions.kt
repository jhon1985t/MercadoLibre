package com.jhonjto.data.service.response

data class Conditions(
    val context_restrictions: List<Any>? = null,
    val eligible: Boolean,
    val end_time: Any? = null,
    val start_time: Any? = null
)