package ktor

import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.serialization.kotlinx.json.json
import org.kodein.di.DI
import org.kodein.di.singleton
import org.kodein.di.bind
import org.kodein.di.instance

val ktorModule = DI.Module("ktorModule"){
    bind<HttpClient>() with singleton {
        HttpClient(HttpEngineFactory.createEngine()){
            install(Logging){
                logger = Logger.SIMPLE
                level = LogLevel.ALL
            }
            install(ContentNegotiation){
                json(instance())
                /*json(Json{
                        ignoreUnknownKeys = true
                        isLenient = true
                    }

                )*/
            }
            install(HttpTimeout){
                connectTimeoutMillis = 15000
                requestTimeoutMillis = 30000
            }
        }
    }
}