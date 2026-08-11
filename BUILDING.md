# Building Melodix (v0.1.0 / Phase 1)

Melodix builds like its upstream, minus the setup pain: the Listen
Together protobuf sources are **committed**, and `gradlew` is executable.

## Requirements (local)

| Tool | Version | Notes |
|---|---|---|
| JDK | 21 | Gradle toolchain enforces it |
| Android SDK | platform 36, build-tools 36.0.0 | `ANDROID_HOME` set, or `local.properties` with `sdk.dir=` |
| protoc | **optional** — only to *regenerate* protos after a `metroproto` update (3.21+, 34.0 matches CI) |
| Git | any | |

## Local build

```bash
git clone <your-melodix-repo-url> melodix && cd melodix
git submodule update --init metroproto     # only needed when regenerating protos

./gradlew assembleFossDebug                # foss = F-Droid style; gms adds Cast
# APK: app/build/outputs/apk/foss/debug/app-foss-debug.apk
```

Optional `local.properties`: `LASTFM_API_KEY`, `LASTFM_SECRET`,
`CRASH_REPORT_REPO`, `CRASH_REPORT_TOKEN`. Optional env:
`MELODIX_APPLICATION_ID`, `MELODIX_APP_NAME`.

Regenerating protos (only after bumping the metroproto submodule):
```bash
(cd app && bash generate_proto.sh)   # needs protoc on PATH
```

Unit tests (fast, JVM-only):
```bash
./gradlew :app:testFossDebugUnitTest :spotify:test :betterlyrics:test
```

## CI build (no local Android SDK needed)

1. Create an empty GitHub repo, push, open a PR:
   ```bash
   git remote add origin https://github.com/<you>/melodix.git
   git push -u origin main && git push origin feat/phase1-design-system
   ```
2. `build_pr.yml` compiles `assembleFossDebug` on GitHub runners and uploads
   `app-universal-debug-pr-<number>.apk` as an artifact.
3. `build.yml` (workflow_dispatch) produces nightly-style release APKs
   (unsigned without signing secrets).

## Install & first-run

- Android 8.0+ (minSdk 26); allow “unknown sources”.
- YouTube Music must be reachable from your region.
- First launch: Melodix dark/pure-black theme, violet seed, EQ-bar “M” icon.
- Spotify/Qobuz are optional, off by default: Settings → Integrations.

## Troubleshooting

- `Permission denied` on `./gradlew` → `chmod +x gradlew` (fixed in-repo; older copies may need this).
- `Missing proto file` → `git submodule update --init metroproto`, then regenerate.
- `Unsupported class file major version` → wrong JDK; use 21.
- Small machines OOM → the build wants ~8 GB RAM (CI runners have 16 GB).

## Signing note
A shared **debug** keystore (`app/persistent-debug.keystore`, credentials
`android`/`android`) is committed so debug builds sign out of the box on any
machine. Release builds still require your own signing setup.
