package domain

import io.ktor.client.HttpClient

interface CatRepository{
    suspend fun getFewCats(): List<CatModel>
}