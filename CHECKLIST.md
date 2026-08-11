# Melodix — Complete Test Checklist (build ≥ U3)

Use after every install. Sections map to shipped phases. Anything failing =
logcat excerpt + device model + Android version in your report.

## 0. Build & install
- [ ] `./gradlew assembleFossDebug` ends BUILD SUCCESSFUL (warnings listed in §6 are known-harmless)
- [ ] APK installs; app appears in launcher as **Melodix** with the EQ-bar “M” icon

## 1. Brand & theme (Phase 0/1)
- [ ] Dark, near-black UI on first launch; pure-black surfaces
- [ ] Accent violet `#7C4DFF` when dynamic theme is OFF (Settings → Appearance)
- [ ] System font everywhere (no bundled fonts)
- [ ] About screen: Melodix Team + repo/license links only; no upstream names anywhere in the app
- [ ] Wrapped intro reads MELODIX

## 2. Core engine regression (inherited)
- [ ] Search → play; notification with controls; background playback with screen off
- [ ] Like → Library → Liked; download → plays in airplane mode
- [ ] Kill from recents → reopen → queue restored
- [ ] Lyrics tab loads (synced for popular tracks)
- [ ] Widgets (music/turntable/recognizer) work exactly as before — they are frozen by design

## 3. Now-playing screen (Meld-kept + bugfix)
- [ ] **Play/pause icon stays visible after every tap** (no need to leave & re-enter) — the reported bug
- [ ] Icon correctly swaps play↔pause↔replay on track end
- [ ] Blur background + wavy slider; 16 dp rounded artwork; pure-black mini-player
- [ ] Prev/next/seek work; long-press title copies; artist link opens

## 4. U2 — haptics
- [ ] Settings → Theme → “Haptic feedback” present, default ON
- [ ] Toggles/switches/taps produce subtle vibration while ON
- [ ] OFF = completely silent haptics; survives restart

## 5. U3 — liquid glass navigation
- [ ] Bottom nav is a **floating rounded pill** with blurred (glass) background over content
- [ ] Active tab shows a **vibrant violet pill indicator**
- [ ] Scrolling Home/Library shows blur updating behind the bar
- [ ] Settings → Theme → “Liquid glass navigation” OFF → classic solid bar returns; ON restores glass; survives restart
- [ ] Navigation behavior unchanged: Home/Search/Library(+Listen Together) routes, search long-press = recognition

## 6. Known-harmless build warnings (do not report)
- `warn: removing resource … without required default value` — translation-only strings
- `w:` Kotlin deprecations in SpotifySettings/AccountSettings/Preference (upstream debt)
- `Unnecessary safe call` / `Elvis always left` warnings (upstream debt)

## 7. Report format
Device / Android version / flavor / version name → what failed → steps →
logcat excerpt (`adb logcat -v time > log.txt` while reproducing).

## 8. U4 — glass mini-player
- [ ] Collapsed mini-player is a translucent rounded glass bar with live blur over scrolling content
- [ ] Settings → Theme → “Liquid glass navigation” OFF → mini-player AND nav return to solid surfaces; ON restores both; survives restart
- [ ] Swipe mini-player up → full now-playing opens unchanged (Meld screen, blur bg, wavy slider)
- [ ] Swipe-down to collapse works; playback controls on the mini-player respond; pure-black behavior when glass OFF unchanged

## 9. U5 — glass top toolbar + bolder typography
- [ ] Top toolbar is transparent with live blur (glass) when “Liquid glass navigation” is ON; solid black/surface when OFF or pure-black
- [ ] Screen titles render in larger bold headline style; home/library section headers visibly larger
- [ ] No layout regression on Home: quick picks, chips, sections, history/stats/account actions all work
- [ ] Scrolling under the toolbar shows blur updating; toolbar text stays readable

## 10. U6 — Melodix-branded home
- [ ] Home toolbar title shows **Melodix** (not “Home”)
- [ ] Home content opens with large violet **Melodix** display heading + “Feel Every Note” tagline above the chips
- [ ] Chips, quick picks and all sections render below unchanged; pull-to-refresh works
- [ ] Other tabs’ toolbar titles unchanged (Search/Library/Together)

## 11. U7 — content language + the eight improvements
- [ ] Cards/lists visibly rounder (20dp) and sections aligned to 24dp chrome
- [ ] Settings opens directly from the gear; long-press gear → About
- [ ] Settings search filters groups live; “Recently changed” row appears after you toggle things
- [ ] Long-press the Melodix home header → quick theme dialog (dark mode + pure black)
- [ ] Appearance → “Copy theme preset” / “Apply theme preset” round-trips via clipboard
- [ ] Widgets get translucent near-black background while Liquid glass is ON
- [ ] Tab switches keep the directional slide+fade (pre-existing, unchanged)

## 12. U8 — your four requests
- [ ] No changelog popup on first launch after update (changelog still reachable from Settings)
- [ ] Settings → last item is **About** (always last, after updater row)
- [ ] Mini-player is now OpenTune-style: circular artwork with wavy progress ring, artist(person) + bouncy heart + vivid filled play/pause; swipe-up to full player unchanged
- [ ] Mini-player like button toggles like with bounce; person opens artist page

## 13. U9 — brand correctness
- [ ] Home shows ONE large violet “Melodix” + “Feel Every Note” (never “Melodix Debug”, no duplicate brand line)
- [ ] Launcher label reads “Melodix” even in debug builds
- [ ] Other tabs keep functional toolbar titles; home toolbar shows icons only

## 14. U10 batch
- [ ] Nav active tab shows a circular primary disc (OpenTune look), M3 pill hidden
- [ ] List rows 8dp / grid thumbs 18dp / cards 24dp; chips rows at 24dp everywhere
- [ ] Local Files: folder icon opens picker; selecting folders rescans only those; empty = all
- [ ] New strings translated in hi/ml/es/fr/de/ru/ja/zh/ar/pt-BR (switch app language to verify)
- [ ] LISTEN_TOGETHER_HOSTING.md explains VPS/Render options (Pages impossible)

## 15. U11 — exact glass + settings parity
- [ ] Glass surfaces now refractive "liquid lens" (kyant backdrop) on toolbar/nav/mini-player; OFF toggle = solid; pre-Android-12 fallback solid dark
- [ ] Mini-player play button uses expressive cookie shape
- [ ] Settings groups: smoother 12dp inner joins, 24dp outer corners, tinted icon containers
- [ ] Account/avatar button goes DIRECTLY to Settings (no popup anywhere)

## 16. v1.0.0 release build
- [ ] About shows Version: 1.0.0
- [ ] Updater checks Cosm1cBug/melodix releases (not upstream) — repoint to your username before publishing (see README "Repointing")
