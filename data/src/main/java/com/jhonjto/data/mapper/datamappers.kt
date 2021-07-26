package com.jhonjto.data.mapper

import com.jhonjto.data.service.response.Result
import com.jhonjto.data.service.response.detail.DetailResponse
import com.jhonjto.data.service.response.detail.DetailResponseItem
import com.jhonjto.domain.*
import com.jhonjto.domain.detail.Body
import com.jhonjto.domain.detail.Detail
import com.jhonjto.domain.detail.DetailItem

/**
 * Created by jhon on 23/07/2021
 */

fun Result.toDomainResult(): com.jhonjto.domain.Result {
    val listAddress = Address(
        address?.city_id,
        address?.city_name,
        address?.state_id,
        address?.state_name
    )

    val listValues = ArrayList<ValueX>()
    attributes?.map { response ->
        response.values?.map {
            listValues.add(
                ValueX(
                    it.id,
                    it.name,
                    it.source,
                    it.struct
                )
            )
        }
    }

    val listAttributes = ArrayList<Attribute>()
    attributes?.map { response ->
        listAttributes.add(
            Attribute(
                response.attribute_group_id,
                response.attribute_group_name,
                response.id,
                response.name,
                response.source,
                response.value_id,
                response.value_name,
                response.value_struct,
                listValues
            )
        )
    }

    val listInstallments = Installments(
        installments?.amount,
        installments?.currency_id,
        installments?.quantity,
        installments?.rate
    )

    val listPresentation = Presentation(
        prices?.presentation?.display_currency
    )

    val listPrice = ArrayList<Price>()
    listPrice.map { response ->
        listPrice.add(
            Price(
                response.amount,
                Conditions(
                    arrayListOf(),
                    response.conditions?.eligible,
                    response.conditions?.end_time,
                    response.conditions?.start_time
                ),
                response.currency_id,
                response.exchange_rate_context,
                response.id,
                response.last_updated,
                response.metadata,
                response.regular_amount,
                response.type
            )
        )
    }

    val listReferencePrice = ArrayList<ReferencePrice>()
    listReferencePrice.map { response ->
        listReferencePrice.add(
            ReferencePrice(
                response.amount,
                ConditionsX(
                    response.conditions?.context_restrictions,
                    response.conditions?.eligible,
                    response.conditions?.end_time,
                    response.conditions?.start_time
                ),
                response.currency_id,
                response.exchange_rate_context,
                response.id,
                response.last_updated,
                response.tags,
                response.type
            )
        )
    }

    val listPrices = Prices(
        prices?.id,
        arrayListOf(),
        listPresentation,
        listPrice,
        arrayListOf(),
        listReferencePrice
    )

    val listEshopLocation = ArrayList<EshopLocation>()
    listEshopLocation.map { response ->
        listEshopLocation.add(
            EshopLocation(
                City(
                    response.city?.id
                ),
                Country(
                    response.country?.id
                ),
                Neighborhood(
                    response.neighborhood?.id
                ),
                State(
                    response.state?.id
                )
            )
        )
    }

    val listSeller = Seller(
        seller?.car_dealer,
        Eshop(
            seller?.eshop?.eshop_experience,
            seller?.eshop?.eshop_id,
            listEshopLocation,
            seller?.eshop?.eshop_logo_url,
            seller?.eshop?.eshop_rubro,
            seller?.eshop?.eshop_status_id,
            seller?.eshop?.nick_name,
            seller?.eshop?.seller,
            seller?.eshop?.site_id
        ),
        seller?.id,
        seller?.permalink,
        seller?.real_estate_agency,
        seller?.registration_date,
        SellerReputation(
            seller?.seller_reputation?.level_id,
            Metrics(
                Cancellations(
                    Excluded(
                        seller?.seller_reputation?.metrics?.cancellations?.excluded?.real_rate,
                        seller?.seller_reputation?.metrics?.cancellations?.excluded?.real_value
                    ),
                    seller?.seller_reputation?.metrics?.cancellations?.period,
                    seller?.seller_reputation?.metrics?.cancellations?.rate,
                    seller?.seller_reputation?.metrics?.cancellations?.value
                ),
                Claims(
                    ExcludedX(
                        seller?.seller_reputation?.metrics?.claims?.excluded?.real_rate,
                        seller?.seller_reputation?.metrics?.claims?.excluded?.real_value
                    ),
                    seller?.seller_reputation?.metrics?.claims?.period,
                    seller?.seller_reputation?.metrics?.claims?.rate,
                    seller?.seller_reputation?.metrics?.claims?.value
                ),
                DelayedHandlingTime(
                    ExcludedXX(
                        seller?.seller_reputation?.metrics?.delayed_handling_time?.excluded?.real_rate,
                        seller?.seller_reputation?.metrics?.delayed_handling_time?.excluded?.real_value
                    ),
                    seller?.seller_reputation?.metrics?.delayed_handling_time?.period,
                    seller?.seller_reputation?.metrics?.delayed_handling_time?.rate,
                    seller?.seller_reputation?.metrics?.delayed_handling_time?.value
                ),
                Sales(
                    seller?.seller_reputation?.metrics?.sales?.completed,
                    seller?.seller_reputation?.metrics?.sales?.period
                )
            ),
            seller?.seller_reputation?.power_seller_status,
            seller?.seller_reputation?.protection_end_date,
            seller?.seller_reputation?.real_level,
            Transactions(
                seller?.seller_reputation?.transactions?.canceled,
                seller?.seller_reputation?.transactions?.completed,
                seller?.seller_reputation?.transactions?.period,
                Ratings(
                    seller?.seller_reputation?.transactions?.ratings?.negative,
                    seller?.seller_reputation?.transactions?.ratings?.neutral,
                    seller?.seller_reputation?.transactions?.ratings?.positive
                ),
                seller?.seller_reputation?.transactions?.total
            )
        ),
        tags = arrayListOf()
    )

    val listSellerAddress = SellerAddress(
        seller_address?.address_line,
        CityX(
            seller_address?.city?.id,
            seller_address?.city?.name
        ),
        seller_address?.comment,
        CountryX(
            seller_address?.country?.id,
            seller_address?.country?.name
        ),
        seller_address?.id,
        seller_address?.latitude,
        seller_address?.longitude,
        StateX(
            seller_address?.state?.id,
            seller_address?.state?.name
        ),
        seller_address?.zip_code
    )

    val listShipping = Shipping(
        shipping?.free_shipping,
        shipping?.logistic_type,
        shipping?.mode,
        shipping?.store_pick_up,
        arrayListOf()
    )

    return Result(
        accepts_mercadopago,
        listAddress,
        listAttributes,
        available_quantity,
        buying_mode,
        catalog_listing,
        catalog_product_id,
        category_id,
        condition,
        currency_id,
        domain_id,
        id,
        listInstallments,
        listing_type_id,
        official_store_id,
        order_backend,
        original_price,
        permalink,
        price,
        listPrices,
        sale_price,
        listSeller,
        listSellerAddress,
        listShipping,
        site_id,
        sold_quantity,
        stop_time,
        tags,
        thumbnail,
        thumbnail_id,
        title,
        use_thumbnail_id
    )
}

fun DetailResponseItem.toDomainDetail(): DetailItem {

    return DetailItem(
        Body(
            body?.condition,
            body?.id,
            body?.price,
            body?.thumbnail,
            body?.title,
            body?.warranty
        ),
        code
    )
}
