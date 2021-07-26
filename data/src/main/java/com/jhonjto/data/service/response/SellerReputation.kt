package com.jhonjto.data.service.response

data class SellerReputation(
    val level_id: String? = null,
    val metrics: Metrics? = null,
    val power_seller_status: String? = null,
    val protection_end_date: String? = null,
    val real_level: String? = null,
    val transactions: Transactions? = null
)