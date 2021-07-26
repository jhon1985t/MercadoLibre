package com.jhonjto.data.service.response

data class Prices(
    val id: String,
    val payment_method_prices: List<Any>? = null,
    val presentation: Presentation? = null,
    val prices: List<Price>? = null,
    val purchase_discounts: List<Any>? = null,
    val reference_prices: List<ReferencePrice>? = null
)