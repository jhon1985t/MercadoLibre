package com.jhonjto.domain

data class Result(
    val accepts_mercadopago: Boolean? = null,
    val address: Address? = null,
    val attributes: List<Attribute>? = null,
    val available_quantity: Int? = null,
    val buying_mode: String? = null,
    val catalog_listing: Boolean? = null,
    val catalog_product_id: String? = null,
    val category_id: String? = null,
    val condition: String? = null,
    val currency_id: String? = null,
    val domain_id: String? = null,
    val id: String? = null,
    val installments: Installments? = null,
    val listing_type_id: String? = null,
    val official_store_id: Int? = null,
    val order_backend: Int? = null,
    val original_price: Any? = null,
    val permalink: String? = null,
    val price: Double? = null,
    val prices: Prices? = null,
    val sale_price: Any? = null,
    val seller: Seller? = null,
    val seller_address: SellerAddress? = null,
    val shipping: Shipping? = null,
    val site_id: String? = null,
    val sold_quantity: Int? = null,
    val stop_time: String? = null,
    val tags: List<String>? = null,
    val thumbnail: String? = null,
    val thumbnail_id: String? = null,
    val title: String? = null,
    val use_thumbnail_id: Boolean? = null
)