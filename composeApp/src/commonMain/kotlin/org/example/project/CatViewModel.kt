package org.example.project

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import data.CatRepositoryImpl
import domain.CatModel
import domain.CatRepository
import io.ktor.client.HttpClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CatViewModel(private val catRepository: CatRepository): ViewModel() {

    private val _cats = MutableStateFlow<List<CatModel>>(emptyList())
    val cats = _cats.asStateFlow()

    fun getCats(){
        viewModelScope.launch {
           _cats.value = catRepository.getFewCats()
        }
    }
}