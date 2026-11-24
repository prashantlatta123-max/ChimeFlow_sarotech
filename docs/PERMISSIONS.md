# Permissions plan

The initial UI prototype requests no runtime permissions.

Planned permissions will be added only when their feature is implemented:
- Exact alarm access: request contextually for precise user-scheduled chimes; provide inexact fallback.
- Notifications: request on Android 13+ when user enables ongoing status/notifications.
- Boot receiver: receive boot completed to rebuild schedules.
- Foreground service permissions/types: only if the final playback design requires them.
- Vibration: declare only when vibration feature is implemented.

Never assume permissions survive backup/restore. Re-check access and reschedule after restore.
