# GitHub Repository Setup for Melodix

Melodix is a **fresh, standalone repository** (single initial commit — no fork
lineage, no upstream remote). Legal provenance lives in `NOTICE.md`/`LICENSE`.

Create an **empty** repo on GitHub (no README/license/init), then:

```bash
git remote add origin https://github.com/<you>/melodix.git
git push -u origin main
```

## About / Description (copy-paste)

> Melodix — Feel Every Note. A minimal, dark-first Material 3 YouTube Music
> client for Android with vibrant accents. Ad-free playback, downloads, synced
> lyrics, Spotify personalization and experimental lossless audio. Free
> software (GPL-3.0).

## Topics / tags

`android` `kotlin` `jetpack-compose` `material3` `music-player`
`youtube-music` `youtube-music-client` `spotify` `lossless`
`lyrics` `fdroid` `gplv3` `melodix`

## Settings checklist

- [ ] Public (GPL-3.0 requires source availability)
- [ ] Issues enabled (inherited templates included)
- [ ] No secrets needed for CI: `build.yml` builds unsigned APKs on push;
      signing steps auto-skip unless `KEYSTORE`/`KEY_ALIAS`/`KEYSTORE_PASSWORD`/
      `KEY_PASSWORD` secrets exist. `build_pr.yml` always produces a debug APK
      artifact on any pull request.
- [ ] Optional secrets later: signing quartet, `LASTFM_API_KEY`/`LASTFM_SECRET`.
- [ ] After push: open any branch as a PR to get the CI debug APK artifact,
      install it, and run `SMOKE-TEST.md`.
