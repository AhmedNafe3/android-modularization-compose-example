package com.jiftun.domain.repository

import com.jiftun.domain.utils.StatusResult
import com.jiftun.entity.CategoryEntity
import com.jiftun.meal.data.model.MealsEntity
import kotlinx.coroutines.flow.Flow

interface MealRepository {
    suspend fun fetchCategoryList(): Flow<StatusResult<List<CategoryEntity>>>
    suspend fun fetchMealByCategory(category: String): Flow<StatusResult<List<MealsEntity>>>

}