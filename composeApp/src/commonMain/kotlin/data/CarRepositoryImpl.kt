package data

import domain.CatRepository
import io.ktor.client.HttpClient

class CarRepositoryImpl(private val httpClient: HttpClient): CatRepository {
    override suspend fun getFewCats() {
        TODO("Not yet implemented")
    }

    override suspend fun getRandomCat() {
        TODO("Not yet implemented")
    }
}