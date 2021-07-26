package com.jhonjto.data.service.response

data class JobResponse(
    val available_filters: List<AvailableFilter>? = null,
    val available_sorts: List<AvailableSort>? = null,
    val country_default_time_zone: String? = null,
    val filters: List<Any>? = null,
    val paging: Paging? = null,
    val query: String? = null,
    val related_results: List<Any>? = null,
    val results: List<Result>? = null,
    val secondary_results: List<Any>? = null,
    val site_id: String? = null,
    val sort: Sort? = null
)