package com.jiftun.domain.usecase

import com.jiftun.domain.repository.MealRepository
import com.jiftun.domain.utils.ApiUseCaseNonParams
import com.jiftun.domain.utils.StatusResult
import com.jiftun.entity.CategoryEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CategoryListUseCase @Inject constructor(
    private val repository: MealRepository
) : ApiUseCaseNonParams<List<CategoryEntity>> {
    override suspend fun execute(): Flow<StatusResult<List<CategoryEntity>>> {
        return repository.fetchCategoryList()
    }
}