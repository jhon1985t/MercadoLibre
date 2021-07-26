package com.jhonjto.data.service.response

data class Paging(
    val limit: Int? = null,
    val offset: Int? = null,
    val primary_results: Int? = null,
    val total: Int? = null
)