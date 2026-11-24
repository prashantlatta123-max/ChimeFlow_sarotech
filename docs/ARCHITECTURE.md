# Architecture

## Planned layers
- UI: Jetpack Compose screens and state holders.
- Domain: scheduling rules and use cases, independent of Android UI.
- Data: Room entities/DAOs, repositories, DataStore preferences.
- Platform: AlarmManager, receivers, TTS, audio and vibration adapters.

## Scheduling principles
- AlarmManager is the source for time-sensitive alarm delivery.
- WorkManager is for deferred maintenance/verification, never as a precise clock.
- Recompute after reboot, app update, time/time-zone changes, schedule edits and exact-alarm access changes.
- Make occurrence handling idempotent to avoid duplicate playback.
- Re-check current slot state when an alarm fires.

## Service policy
Do not keep a permanent foreground service solely to run a timer. Use short, policy-compliant playback work and a foreground service only when the actual operation and Android version permit it.

## Persistence
Room for relational slot/schedule data; DataStore for small app preferences. Database migrations must be explicit and tested.
