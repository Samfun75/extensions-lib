package eu.kanade.tachiyomi.animesource.model

import android.net.Uri
import okhttp3.Headers

/**
 * A sub/dub track.
 */
data class Track(val url: String, val lang: String)

/**
 * The instance that contains the data needed to watch a video.
 */
@Suppress("unused_parameter")
data class Video(val url: String,
                 val quality: String,
                 var videoUrl: String?,
                 val headers: Headers? = null,
                 val subtitleTracks: List<Track> = emptyList(),
                 val audioTracks: List<Track> = emptyList(),
                 val getDecryptionKey: (() -> Pair<DecryptionType, String>)? = null
) {
    constructor(url: String,
                quality: String,
                videoUrl: String?,
                uri: Uri? = null,
                headers: Headers? = null) : this(url, quality, videoUrl, headers)

    enum class DecryptionType(val type: String) {
        CRYPTO_KEY("cryptokey"),
        DECRYPTION_KEY("decryption_key"),
        CENC_DECRYPTION_KEY("cenc_decryption_key"),
    }
}
