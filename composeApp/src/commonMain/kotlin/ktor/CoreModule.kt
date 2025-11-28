package ktor

import json.jsonModule
import org.kodein.di.DI

val coreModule  = DI.Module("coreModule"){
    importAll(
        ktorModule,
        jsonModule
    )
}