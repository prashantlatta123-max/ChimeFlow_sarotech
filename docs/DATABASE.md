# Planned database model

Entities (final schema to be reviewed before first migration):
- ChimeSlotEntity
- ScheduleEntity
- ActivePeriodEntity
- BellEntity
- VibrationPatternEntity
- AppRuntimeEntity

Keep custom audio bytes in app-private files, not database blobs. Store metadata and managed file identifiers in Room.

Runtime fields should include next/last chime timestamps, pause-until, session token, schedule version and last handled occurrence identifier.

Handle overlapping ranges, midnight-crossing ranges, simultaneous slots and time-zone changes explicitly.
