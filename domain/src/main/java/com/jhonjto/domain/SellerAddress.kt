package com.jhonjto.domain

data class SellerAddress(
    val address_line: String? = null,
    val city: CityX? = null,
    val comment: String? = null,
    val country: CountryX? = null,
    val id: String? = null,
    val latitude: String? = null,
    val longitude: String? = null,
    val state: StateX? = null,
    val zip_code: String? = null
)