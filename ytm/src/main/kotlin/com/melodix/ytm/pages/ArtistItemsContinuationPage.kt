package com.melodix.ytm.pages

import com.melodix.ytm.models.YTItem

data class ArtistItemsContinuationPage(
    val items: List<YTItem>,
    val continuation: String?,
)
