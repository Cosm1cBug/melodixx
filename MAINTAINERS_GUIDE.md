# Melodix Maintainers Guide — Repo Identity & App Pages

Current identity: **Cosm1cBug/melodix** · app id `com.melodix.app` · version in `app/build.gradle.kts`.

---

## A. Changing your GitHub username / repo later

Every place the repo identity lives, and what it does:

| # | File | What it controls |
|---|---|---|
| 1 | `app/src/main/kotlin/com/melodix/music/utils/Updater.kt` | `GITHUB_API_BASE` — in-app **update checks** (releases/latest, changelog fetch) |
| 2 | `app/src/main/res/values/melodix_strings.xml` | `github_releases_url` — "view releases" links in Settings/Updater |
| 3 | `app/src/main/kotlin/com/melodix/music/ui/screens/settings/AboutScreen.kt` | repo + license buttons, and the two `avatarUrl = raw.githubusercontent…icon.png` (About avatars) |
| 4 | `app/src/main/kotlin/com/melodix/music/utils/SpotifyHashSync.kt` | `REMOTE_URL` — self-hosted **Spotify GQL hash registry** (raw JSON) |
| 5 | `app/src/main/kotlin/com/melodix/music/api/OpenRouterService.kt` & `OpenRouterStreamingService.kt` | `HTTP-Referer` headers for AI lyric translation |
| 6 | `app/build.gradle.kts` | `CRASH_REPORT_REPO` default — where crash-report issues get filed |
| 7 | `README.md`, `GITHUB-REPO.md`, `NOTICE.md`, `CHECKLIST.md` | documentation links |
| 8 | *(git, not a file)* | `git remote set-url origin https://github.com/NEWNAME/melodix.git` |
| 9 | *(GitHub web, not a file)* | Repo **Settings → Pages** (if enabled) · repo **Settings** rename keeps redirects, but raw URLs change |

### One-command rename (replace NEWNAME)
```bash
cd melodix
grep -rl "Cosm1cBug/melodix" app/src README.md GITHUB-REPO.md NOTICE.md CHECKLIST.md app/build.gradle.kts \
  | xargs sed -i "s|Cosm1cBug/melodix|NEWNAME/melodix|g"
git remote set-url origin https://github.com/NEWNAME/melodix.git
```
Then rebuild & publish a release so the in-app updater follows the new repo.
If you only renamed the *repo* (not username), the same command works because both
appear as `owner/melodix`.

---

## B. Editing any page in the app — file map

### Main tabs
| Page | File(s) |
|---|---|
| Home (brand header, sections, chips) | `ui/screens/HomeScreen.kt` · `viewmodels/HomeViewModel.kt` |
| Search | `ui/screens/search/SearchScreen.kt` · `viewmodels/SearchViewModel.kt` |
| Library (landing + chips) | `ui/screens/library/LibraryScreen.kt` |
| Library → Songs/Albums/Artists/Playlists/Mix/Podcasts | `library/LibrarySongsScreen.kt`, `LibraryAlbumsScreen.kt`, `LibraryArtistsScreen.kt`, `LibraryPlaylistsScreen.kt`, `LibraryMixScreen.kt`, `LibraryPodcastsScreen.kt` |
| Library → Local files (+ folder filter) | `library/local/LocalFilesScreen.kt` · `viewmodels/LocalFilesViewModel.kt` |
| Listen Together | `ui/screens/ListenTogetherScreen.kt` · `settings/integrations/ListenTogetherSettings.kt` |

### Detail / secondary pages
| Page | File |
|---|---|
| Album / Artist / Playlist | `ui/screens/AlbumScreen.kt`, `artist/ArtistScreen.kt`, `playlist/PlaylistScreen.kt` |
| Browse / Charts / Explore / Mood & Genres / New releases | `BrowseScreen.kt`, `ChartsScreen.kt`, `ExploreScreen.kt`, `MoodAndGenresScreen.kt`, `NewReleaseScreen.kt` |
| History / Stats / Wrapped | `HistoryScreen.kt`, `StatsScreen.kt`, `wrapped/*` |
| Account & logins | `AccountScreen.kt`, `LoginScreen.kt`, `SpotifyLoginScreen.kt` |
| Recognition (Shazam-style) | `recognition/*` |
| Equalizer | `equalizer/*` |
| Podcasts | `podcast/*` |

### Now-playing (kept from Meld by design)
`ui/player/Player.kt` (full player) · `MiniPlayer.kt` (mini bar, OpenTune layout) ·
`Queue.kt` · `Thumbnail.kt`.

### Settings
Root: `settings/SettingsScreen.kt`. Sub-pages: `AppearanceSettings.kt` (theme, glass,
haptics, presets), `PlayerSettings.kt`, `ContentSettings.kt`, `PrivacySettings.kt`,
`StorageSettings.kt`, `AccountSettings.kt`, `AndroidAutoSettings.kt`, `AlarmSettings.kt`,
`AiSettings.kt`, `RomanizationSettings.kt`, `SponsorBlockSettings.kt`,
`UpdaterSettings.kt`, `BackupAndRestore.kt`, `ChangelogScreen.kt`, `AboutScreen.kt`,
`ThemeScreen.kt`, integrations: `integrations/SpotifySettings.kt`,
`SpotifyPreloadScreen.kt`, `DiscordSettings.kt`, `LastFMSettings.kt`,
`ListenTogetherSettings.kt`, `IntegrationScreen.kt`.

### Global look & feel (changes affect many pages at once)
| Concern | File |
|---|---|
| Colors / seed / dark & pure-black | `ui/theme/Theme.kt` |
| Fonts | `ui/theme/Type.kt` (+ `res/font/`) |
| Corners & paddings tokens | `constants/Dimensions.kt` |
| Card/list/grid item look | `ui/component/Items.kt` |
| Bottom nav (glass pill, circular indicator) | `ui/component/AppNavigation.kt` |
| Glass renderer | `ui/component/LiquidGlass.kt` |
| Settings cards | `ui/component/Material3SettingsGroup.kt` |
| Chips rows | `ui/component/ChipsRow.kt` |
| Navigation routes | `ui/screens/NavigationBuilder.kt`, `Screens.kt` |
| All texts | `res/values/strings.xml`, `res/values/melodix_strings.xml`, translations `res/values-XX/…` |
| Icons | `res/drawable/*.xml` |
| Launcher icon + app label | `res/mipmap-*`, `AndroidManifest.xml` (`brand_name` string) |
| Widgets | `widget/*` + `res/layout/widget_*.xml` |

**Rule of thumb:** one page = its `…Screen.kt`; anything shared = the component/theme
files above. Strings always go in `melodix_strings.xml` (default locale) first, then
translate in `values-XX/`.
