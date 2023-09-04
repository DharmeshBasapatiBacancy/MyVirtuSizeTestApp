package com.example.myvirtusizetestapp.di

import com.example.myvirtusizetestapp.network.service.ApiService
import com.example.myvirtusizetestapp.repository.ProductsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideMainRepository(apiService: ApiService): ProductsRepository {
        return ProductsRepository(apiService)
    }

}