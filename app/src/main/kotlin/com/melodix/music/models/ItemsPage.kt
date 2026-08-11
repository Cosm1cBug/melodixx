/**
 * Melodix Project (C) 2026
 * Licensed under GPL-3.0 | See git history for contributors
 */

package com.melodix.music.models

import com.melodix.ytm.models.YTItem

data class ItemsPage(
    val items: List<YTItem>,
    val continuation: String?,
)
