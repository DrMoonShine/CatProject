package org.example.project

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import catproject.composeapp.generated.resources.Res
import catproject.composeapp.generated.resources.compose_multiplatform
import data.CatRepositoryImpl
import di.httpClientModule
import di.mainDI
import di.repositoryModule
import domain.CatRepository
import org.kodein.di.DI
import org.kodein.di.direct
import org.kodein.di.instance


@Composable
fun App() {

    MaterialTheme {
        val viewModel = remember {
            CatViewModel(mainDI.direct.instance())
        }
        val cats by viewModel.cats.collectAsState()

        var showContent by remember { mutableStateOf(false) }
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primaryContainer)
                .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            /*Button(onClick = { showContent = !showContent }) {
                Text("Click me!")
            }*/
            Button(onClick = { viewModel.getCats()}) {
                Text("CAAAATS!")
            }
            if (cats.isNotEmpty()){
                Text(cats.first().toString())
            }
            AnimatedVisibility(showContent) {
                val greeting = remember { Greeting().greet() }
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Image(painterResource(Res.drawable.compose_multiplatform), null)
                    Text("Compose: $greeting")
                }
            }
        }
    }
}

