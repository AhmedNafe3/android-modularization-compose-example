package com.jiftun.catalog.categories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jiftun.domain.usecase.CategoryListUseCase
import com.jiftun.domain.utils.StatusResult
import com.jiftun.entity.CategoryEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoriesViewModel @Inject constructor(private val categoryUseCase: CategoryListUseCase) :
    ViewModel() {
    private val _mealCategoriesListUiState =
        MutableStateFlow<CategoryListUiState>(CategoryListUiState.Loading)
    val mealCategoriesListUiState get() = _mealCategoriesListUiState.asStateFlow()

    init {
        fetchCategoryList()
    }

    private fun fetchCategoryList() {
        viewModelScope.launch {
            categoryUseCase.execute().collect { response ->
                when (response) {
                    is StatusResult.Error -> _mealCategoriesListUiState.value =
                        CategoryListUiState.Error(response.message)

                    is StatusResult.Loading -> _mealCategoriesListUiState.value =
                        CategoryListUiState.Loading

                    is StatusResult.Success -> {
                        if (response.data.isEmpty()) {
                            _mealCategoriesListUiState.value = CategoryListUiState.CategoryListEmpty
                            return@collect
                        }
                        _mealCategoriesListUiState.value =
                            CategoryListUiState.HasCategoryList(response.data)
                    }

                    else -> {}
                }
            }
        }
    }

}

sealed interface CategoryListUiState {
    data object Loading : CategoryListUiState
    data class HasCategoryList(val categories: List<CategoryEntity>) : CategoryListUiState
    data object CategoryListEmpty : CategoryListUiState
    data class Error(val message: String) : CategoryListUiState
}