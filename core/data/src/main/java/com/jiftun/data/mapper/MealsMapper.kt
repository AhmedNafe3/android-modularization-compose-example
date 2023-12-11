package com.jiftun.data.mapper

import com.jiftun.apiresponse.MealsResponse
import com.jiftun.data.utils.Mapper
import com.jiftun.meal.data.model.MealsEntity
import javax.inject.Inject

class MealsMapper @Inject constructor() : Mapper<MealsResponse, List<MealsEntity>> {
    override fun mapFromApiResponse(type: MealsResponse): List<MealsEntity> {
        return type.meals.map {
            MealsEntity(idMeal = it.idMeal, strMeal = it.strMeal, strMealThumb = it.strMealThumb)
        }
    }
}