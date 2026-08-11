package com.melodix.ytm.models.body

import com.melodix.ytm.models.Context
import com.melodix.ytm.models.Continuation
import kotlinx.serialization.Serializable

@Serializable
data class BrowseBody(
    val context: Context,
    val browseId: String?,
    val params: String?,
    val continuation: String?
)
