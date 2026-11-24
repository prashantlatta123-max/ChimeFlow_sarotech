# ChimeFlow

An independent, offline-first Android chime and speaking-clock app.

## Current status

**Phase 1 foundation / UI prototype.** This is not yet a complete chime application.
The Start/Stop control currently changes prototype UI state only. Alarm scheduling,
database persistence, TTS playback, vibration, backup/restore and full localization
are planned for later phases.

## Requirements

- Android Studio with JDK 17
- Android SDK Platform 36
- Gradle 8.13 (CI installs it; generate and commit the Wrapper locally for reproducible builds)

## Android compatibility

- Minimum SDK: 29 (Android 10)
- Compile SDK: 36
- Target SDK: 36

## Build

Open this folder in Android Studio and allow Gradle sync to finish.

Debug:
```bash
gradle assembleDebug
```

Release:
```bash
gradle assembleRelease
```

Windows:
```bat
gradle assembleDebug
```

The release build enables R8 and resource shrinking. Release signing is intentionally
not configured; configure a private signing key locally or through protected CI secrets.
Never commit signing keys or passwords.

## Design decisions

- Kotlin + Jetpack Compose
- Room and DataStore dependencies staged for upcoming persistence work
- Offline-first; no analytics, ads, Firebase, billing or mandatory network dependency
- System-following Light/Dark theme foundation
- No proprietary code or assets copied from third-party apps

## Roadmap

1. Foundation and UI shell
2. Room schema, repositories and independent chime slots
3. Daily/weekly scheduling and AlarmManager
4. Sound, TTS and vibration
5. Reliability and permission recovery
6. Backup/restore
7. Device testing and release

## Quality policy

Every feature must include relevant tests and pass compilation, lint and regression
checks before merging into `main`. Android alarm delivery is subject to OS and
manufacturer restrictions; no app can promise perfect timing under every condition.
