package di

import kotlinx.serialization.json.Json
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.singleton

internal val jsonModule = DI.Module("jsonModule"){
    bind<Json>() with singleton {
        Json{
            ignoreUnknownKeys = true
            isLenient = true
        }
    }
}