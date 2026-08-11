# Melodix — First-Run Smoke Test

Run this after installing a fresh debug APK (Android 8+ device).
Mark each item; anything failing = open an issue with logcat.

## Launch & brand
- [ ] App installs; launcher shows the **EQ-bar “M”** icon (violet→cyan on black)
- [ ] App name reads **Melodix**; first screen is **dark / pure black**
- [ ] Text renders in the clean system font (no bundled fonts)
- [ ] Bottom nav is the **slim** variant; seed/accent color is **violet #7C4DFF**

## Core playback
- [ ] Search “A. R. Rahman” → results load (songs/albums/artists tabs)
- [ ] Tap a song → plays; notification with artwork + controls appears
- [ ] Background playback continues with screen off / app switched
- [ ] Expand player: **blur background** + **wavy progress slider** visible
- [ ] Like the song → appears under Library → Liked
- [ ] Download a song → playable with network off (airplane mode)

## Lyrics & audio
- [ ] Lyrics tab shows synced lyrics (or “Lyrics not found” for obscure tracks)
- [ ] Settings → Player: skip silence toggle works; tempo/pitch dialog opens
- [ ] Sleep timer can be set from the player menu

## Library & sync
- [ ] (Optional) Log in with YouTube account → library/liked sync appears
- [ ] Create a local playlist; add songs; reorder works

## Integrations (optional, off by default)
- [ ] Settings → Integrations → Spotify → login WebView completes
- [ ] Home shows Spotify sections when “Use Spotify for home” enabled
- [ ] Last.fm / Discord RPC connect when configured

## Platform extras
- [ ] Long-press home → widget list shows **Melodix** widgets; add one, controls work
- [ ] Android Auto (if available): app appears, browses, plays
- [ ] Rotate device / dark-light toggle: UI stays consistent (pure black retained)

## Stability
- [ ] 10-minute listening session: no crashes, no ANR
- [ ] Kill app from recents → reopen: queue restored (persistent queue default)

Report format: device model, Android version, APK variant (foss/gms),
version (Settings → About), logcat excerpt.
