package data


import io.ktor.client.engine.HttpClientEngineConfig
import io.ktor.client.engine.HttpClientEngineFactory

expect object HttpEngineFactory {
    fun createEngine(): HttpClientEngineFactory<HttpClientEngineConfig>
}