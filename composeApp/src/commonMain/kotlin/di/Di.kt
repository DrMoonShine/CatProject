package di

import org.kodein.di.DI

val mainDI = DI {
    import(coreModule)
}