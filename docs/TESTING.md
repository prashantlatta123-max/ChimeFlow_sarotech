# Testing strategy

## Every pull request
- Gradle compilation
- Unit tests
- Android lint
- Debug APK build
- Relevant regression tests

## Device matrix
- Android 10 / API 29
- Android 12 / API 31+ (exact alarm access behavior)
- Android 13 / API 33+ (notification permission)
- Android 14+ (exact alarm and foreground service policy)
- Current target API device

## Scheduling scenarios
- Reboot
- Time and time-zone changes
- Doze and battery saver
- Exact-alarm access denied/revoked
- App update
- Slot edited/disabled
- Overlapping and simultaneous slots
- Midnight-crossing active periods
- Duplicate alarm prevention

## Release gate
Do not mark a release stable until build, lint, tests, install/launch and real-device scheduling tests pass.
