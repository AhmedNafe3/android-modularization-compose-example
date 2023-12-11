package com.jiftun.data.repoimpl

import com.jiftun.data.utils.mapFromApiResponse
import com.jiftun.data.apiservice.ApiService
import com.jiftun.data.mapper.CategoryMealListMapper
import com.jiftun.data.mapper.MealsMapper
import com.jiftun.data.utils.NetworkBoundResource
import com.jiftun.domain.repository.MealRepository
import com.jiftun.domain.utils.StatusResult
import com.jiftun.entity.CategoryEntity
import com.jiftun.meal.data.model.MealsEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MealsRepoImpl @Inject constructor(
    private val apiService: ApiService,
    private val networkBoundResources: NetworkBoundResource,
    private val categoryListItemMapper: CategoryMealListMapper,
    private val mealsMapper: MealsMapper,
) : MealRepository {

    override suspend fun fetchCategoryList(): Flow<StatusResult<List<CategoryEntity>>> {
        return mapFromApiResponse(
            statusResult = networkBoundResources.downloadData {
                apiService.getCategoryList()
            }, categoryListItemMapper
        )
    }

    override suspend fun fetchMealByCategory(category: String): Flow<StatusResult<List<MealsEntity>>> {
        return mapFromApiResponse(statusResult = networkBoundResources.downloadData {
            apiService.getMealsByCategory(category)
        }, mealsMapper)
    }

}