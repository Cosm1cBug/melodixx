package com.melodix.ytm.pages

import com.melodix.ytm.models.YTItem

data class LibraryContinuationPage(
    val items: List<YTItem>,
    val continuation: String?,
)
