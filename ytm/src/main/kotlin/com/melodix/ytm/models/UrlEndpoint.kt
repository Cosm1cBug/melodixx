package com.melodix.ytm.models

import kotlinx.serialization.Serializable

@Serializable
data class UrlEndpoint(
    val url: String? = null,
    val target: String? = null,
)
