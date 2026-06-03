package data

import domain.CatModel
import domain.CatRepository
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.util.network.UnresolvedAddressException
import kotlinx.serialization.SerializationException

class CatRepositoryImpl(private val httpClient: HttpClient): CatRepository {
    override suspend fun getFewCats(): List<CatModel> {
        val response = try {
            httpClient.get(
                urlString = "https://cataas.com/api/cats"
            ){
                parameter("tags", "tag1,tag2")
                parameter("skip", 0)
                parameter("limit", 5)
            }
        } catch (e: Exception){
           return emptyList()
        }

        return if(response.status.value in 200..299) response.body()
        else emptyList()
    }
}