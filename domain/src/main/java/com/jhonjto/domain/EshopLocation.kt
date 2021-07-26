package com.jhonjto.domain

data class EshopLocation(
    val city: City? = null,
    val country: Country? = null,
    val neighborhood: Neighborhood? = null,
    val state: State? = null
)