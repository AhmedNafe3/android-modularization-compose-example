package com.jiftun.talamobile.di


import com.jiftun.data.repoimpl.MealsRepoImpl
import com.jiftun.domain.repository.MealRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule{

    @Binds
    fun bindMealRepository(mealRepo: MealsRepoImpl): MealRepository

}