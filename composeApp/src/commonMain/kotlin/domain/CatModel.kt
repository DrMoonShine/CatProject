package domain

import kotlinx.serialization.Serializable

@Serializable
data class CatModel (
    val id: String,
    val tags: String,
    val mimetype: String,
    val createdAt: String
)
