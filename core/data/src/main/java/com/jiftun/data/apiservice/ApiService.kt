package com.jiftun.data.apiservice

import com.jiftun.apiresponse.CategoryResponse
import com.jiftun.apiresponse.MealsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {
    @GET("categories.php")
    suspend fun getCategoryList(): Response<CategoryResponse>

    @GET("filter.php")
    suspend fun getMealsByCategory(@Query("c") category: String): Response<MealsResponse>
}