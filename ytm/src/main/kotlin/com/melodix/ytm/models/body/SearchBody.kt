package com.melodix.ytm.models.body

import com.melodix.ytm.models.Context
import kotlinx.serialization.Serializable

@Serializable
data class SearchBody(
    val context: Context,
    val query: String?,
    val params: String?,
)
