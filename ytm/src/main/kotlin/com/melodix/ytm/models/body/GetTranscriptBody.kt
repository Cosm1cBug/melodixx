package com.melodix.ytm.models.body

import com.melodix.ytm.models.Context
import kotlinx.serialization.Serializable

@Serializable
data class GetTranscriptBody(
    val context: Context,
    val params: String,
)
