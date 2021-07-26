package com.jhonjto.data.service.response

data class AvailableFilter(
    val id: String? = null,
    val name: String? = null,
    val type: String? = null,
    val values: List<Value>? = null
)