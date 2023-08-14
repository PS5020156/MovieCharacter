package com.movie.character.di

import com.movie.character.core.utils.Constants.BASE_URL
import com.movie.character.data.api.CharacterApi
import com.movie.character.data.repository.CharacterRepositoryImpl
import com.movie.character.domain.repository.CharacterRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Provides
    @Singleton
    fun provideRetrofitInstance() : Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    @Provides
    @Singleton
    fun provideCharactersApi(retrofit: Retrofit) : CharacterApi = retrofit.create(CharacterApi::class.java)

    @Provides
    @Singleton
    fun provideCharacterRepository(api: CharacterApi) : CharacterRepository {
        return CharacterRepositoryImpl(api)
    }


}