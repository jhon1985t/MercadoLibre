package com.jhonjto.domain

data class Price(
    val amount: Double? = null,
    val conditions: Conditions? = null,
    val currency_id: String? = null,
    val exchange_rate_context: String? = null,
    val id: String? = null,
    val last_updated: String? = null,
    val metadata: Metadata? = null,
    val regular_amount: Any? = null,
    val type: String? = null
)