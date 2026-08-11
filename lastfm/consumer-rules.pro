# Keep the LastFM singleton and all its public/private members
-keep class com.melodix.lastfm.LastFM { *; }
-keep class com.melodix.lastfm.LastFM$LastFmException { *; }

# Keep serializable model classes used for JSON parsing
-keep class com.melodix.lastfm.models.** { *; }
