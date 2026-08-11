package com.melodix.ytm.models.body

import com.melodix.ytm.models.Context
import kotlinx.serialization.Serializable

@Serializable
data class GetSearchSuggestionsBody(
    val context: Context,
    val input: String,
)
