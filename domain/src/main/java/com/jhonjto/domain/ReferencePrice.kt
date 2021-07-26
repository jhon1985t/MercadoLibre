package com.jhonjto.domain

data class ReferencePrice(
    val amount: Double? = null,
    val conditions: ConditionsX? = null,
    val currency_id: String? = null,
    val exchange_rate_context: String? = null,
    val id: String? = null,
    val last_updated: String? = null,
    val tags: List<Any>? = null,
    val type: String? = null
)