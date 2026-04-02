package di

import org.kodein.di.DI


val coreModule = DI.Module("di.coreModule"){
    importAll(
        httpClientModule,
        jsonModule,
        dbModule
    )
}