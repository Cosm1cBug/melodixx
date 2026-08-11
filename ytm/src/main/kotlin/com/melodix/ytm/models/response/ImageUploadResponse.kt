package com.melodix.ytm.models.response

import kotlinx.serialization.Serializable

@Serializable
data class ImageUploadResponse(
    val encryptedBlobId: String
)