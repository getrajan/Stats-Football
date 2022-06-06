package com.Stats.Football.di


import com.Stats.Football.common.Constants
import com.Stats.Football.data.remote.SportStatApi
import com.Stats.Football.data.repository.AppRepositoryImpl
import com.Stats.Football.domain.repository.AppRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideSportStatApi(): SportStatApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SportStatApi::class.java)
    }

    @Provides
    @Singleton
    fun provideAppRepository(api: SportStatApi): AppRepository {
        return AppRepositoryImpl(api)
    }
}