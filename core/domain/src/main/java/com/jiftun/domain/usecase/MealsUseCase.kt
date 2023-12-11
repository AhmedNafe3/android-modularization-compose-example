package com.jiftun.domain.usecase

import com.jiftun.domain.repository.MealRepository
import com.jiftun.domain.utils.ApiUseCaseParams
import com.jiftun.domain.utils.StatusResult
import com.jiftun.meal.data.model.MealsEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MealsUseCase @Inject constructor(
    private val mealRepository: MealRepository
) : ApiUseCaseParams<MealsUseCase.Params, List<MealsEntity>> {
    data class Params(val category: String)

    override suspend fun execute(params: Params): Flow<StatusResult<List<MealsEntity>>> {
        return mealRepository.fetchMealByCategory(params.category)
    }
}