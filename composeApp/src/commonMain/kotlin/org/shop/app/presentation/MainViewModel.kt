package org.shop.app.presentation

import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.shop.app.domain.repository.Repository
import org.shop.app.domain.usecase.ResultState

class MainViewModel(private val repository: Repository): ViewModel() {
    private val _product = MutableStateFlow<ResultState>(ResultState.LOADING)
    val products : StateFlow<ResultState> = _product.asStateFlow()

    fun getProducts(){
        viewModelScope.launch {
            _product.value = ResultState.LOADING
            try {
                val response = repository.getProducts()
                _product.value = ResultState.SUCCESS(response)
            }catch (e: Exception){
                _product.value = ResultState.ERROR(e.message.toString())
            }
        }
    }
}