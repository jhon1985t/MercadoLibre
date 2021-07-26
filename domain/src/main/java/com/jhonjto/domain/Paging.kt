package com.jhonjto.domain

data class Paging(
    val limit: Int? = null,
    val offset: Int? = null,
    val primary_results: Int? = null,
    val total: Int? = null
)