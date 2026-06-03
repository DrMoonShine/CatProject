package di


import data.CatRepositoryImpl
import domain.CatRepository
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton

val repositoryModule  = DI.Module("repositoryModule"){
    bind<CatRepository>() with singleton {
        CatRepositoryImpl(instance())
    }
}

