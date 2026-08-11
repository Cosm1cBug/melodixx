/**
 * Melodix Project (C) 2026
 * Licensed under GPL-3.0 | See git history for contributors
 */

package com.melodix.music.models

import com.melodix.ytm.models.YTItem
import com.melodix.music.db.entities.LocalItem

data class SimilarRecommendation(
    val title: LocalItem,
    val items: List<YTItem>,
)
