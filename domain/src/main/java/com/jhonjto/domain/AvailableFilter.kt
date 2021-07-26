package com.jhonjto.domain

data class AvailableFilter(
    val id: String? = null,
    val name: String? = null,
    val type: String? = null,
    val values: List<Value>? = null
)