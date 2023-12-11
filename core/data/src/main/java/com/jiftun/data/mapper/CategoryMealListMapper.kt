package com.jiftun.data.mapper

import com.jiftun.apiresponse.CategoryResponse
import com.jiftun.data.utils.Mapper
import com.jiftun.entity.CategoryEntity
import javax.inject.Inject

class CategoryMealListMapper @Inject constructor() :
    Mapper<CategoryResponse, List<CategoryEntity>> {

    override fun mapFromApiResponse(type: CategoryResponse): List<CategoryEntity> {
        return type.categories.map {
            CategoryEntity(
                idCategory = it.idCategory,
                strCategory = it.strCategory,
                strCategoryDescription = it.strCategoryDescription,
                strCategoryThumb = it.strCategoryThumb,
            )
        }
    }
}