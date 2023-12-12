package com.jiftun.catalog.meals

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jiftun.domain.usecase.MealsUseCase
import com.jiftun.domain.utils.StatusResult
import com.jiftun.meal.data.model.MealsEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MealsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle, private val mealsUseCase: MealsUseCase
) : ViewModel() {
    private val categoryName: String = checkNotNull(savedStateHandle["categoryName"])

    private val _mealListUiState = MutableStateFlow<MealsUiState>(MealsUiState.Loading)
    val mealListUiState get() = _mealListUiState.asStateFlow()

    init {
        fetchMealList(categoryName)
    }

    private fun fetchMealList(categoryName: String) {
        viewModelScope.launch {
            mealsUseCase.execute(MealsUseCase.Params(category = categoryName)).collect { response ->
                when (response) {
                    is StatusResult.Error -> _mealListUiState.value =
                        MealsUiState.Error(response.message)

                    is StatusResult.Loading -> _mealListUiState.value = MealsUiState.Loading
                    is StatusResult.Success -> _mealListUiState.value =
                        MealsUiState.HasMealsList(response.data)
                }
            }
        }
    }
}

sealed interface MealsUiState {
    data object Loading : MealsUiState
    data class HasMealsList(val mealsEntity: List<MealsEntity>) : MealsUiState
    data object MealsListEmpty : MealsUiState
    data class Error(val message: String) : MealsUiState
}