package com.melodix.ytm.pages

import com.melodix.ytm.models.Album
import com.melodix.ytm.models.AlbumItem
import com.melodix.ytm.models.Artist
import com.melodix.ytm.models.ArtistItem
import com.melodix.ytm.models.MusicResponsiveListItemRenderer
import com.melodix.ytm.models.MusicTwoRowItemRenderer
import com.melodix.ytm.models.PlaylistItem
import com.melodix.ytm.models.SongItem
import com.melodix.ytm.models.YTItem
import com.melodix.ytm.models.oddElements
import com.melodix.ytm.utils.parseTime

data class LibraryAlbumsPage(
    val albums: List<AlbumItem>,
    val continuation: String?,
) {
    companion object {
        fun fromMusicTwoRowItemRenderer(renderer: MusicTwoRowItemRenderer): AlbumItem? {
            return AlbumItem(
                        browseId = renderer.navigationEndpoint.browseEndpoint?.browseId ?: return null,
                        playlistId = renderer.thumbnailOverlay?.musicItemThumbnailOverlayRenderer?.content
                            ?.musicPlayButtonRenderer?.playNavigationEndpoint
                            ?.watchPlaylistEndpoint?.playlistId ?: return null,
                        title = renderer.title.runs?.firstOrNull()?.text ?: return null,
                        artists = null,
                        year = renderer.subtitle?.runs?.lastOrNull()?.text?.toIntOrNull(),
                        thumbnail = renderer.thumbnailRenderer.musicThumbnailRenderer?.getThumbnailUrl() ?: return null,
                        explicit = renderer.subtitleBadges?.find {
                            it.musicInlineBadgeRenderer?.icon?.iconType == "MUSIC_EXPLICIT_BADGE"
                        } != null
                    )
        }
    }
}
