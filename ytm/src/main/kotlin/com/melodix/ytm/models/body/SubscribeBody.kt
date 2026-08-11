package com.melodix.ytm.models.body

import com.melodix.ytm.models.Context
import kotlinx.serialization.Serializable

@Serializable
data class SubscribeBody(
    val channelIds: List<String>,
    val context: Context,
    val params: String? = null,
)
