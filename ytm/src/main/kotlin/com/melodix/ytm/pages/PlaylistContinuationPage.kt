package com.melodix.ytm.pages

import com.melodix.ytm.models.SongItem

data class PlaylistContinuationPage(
    val songs: List<SongItem>,
    val continuation: String?,
)
