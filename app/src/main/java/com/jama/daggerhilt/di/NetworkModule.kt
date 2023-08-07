package com.jama.daggerhilt.di

import com.jama.daggerhilt.networking.GithubService
import com.jama.daggerhilt.networking.JsonPlaceHolderService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Url
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Provides
    @Singleton
    @Named(value = "jsonplaceholder")
    fun provideJsonPlaceHolderBaseUrl():String = "https://jsonplaceholder.typicode.com/"

    @Provides
    @Singleton
    @Named(value = "github")
    fun provideGithubBaseUrl():String = "https://api.github.com/"

    @Provides
    @Singleton
    @Named("retrofitJsonPlaceHolder")
    fun provideRetrofitJsonPlaceHolder(@Named("jsonplaceholder") baseUrl: String):Retrofit{
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(OkHttpClient().newBuilder().build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    @Provides
    @Singleton
    @Named("retrofitGithub")
    fun provideRetrofit(@Named("github") baseUrl: String):Retrofit{
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(OkHttpClient().newBuilder().build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    @Provides
    @Singleton
    fun provideJsonPlaceHolder(@Named("retrofitJsonPlaceHolder") retrofit: Retrofit):JsonPlaceHolderService{
        return retrofit.create(JsonPlaceHolderService::class.java)
    }
    @Provides
    @Singleton
    fun provideGithub(@Named("retrofitGithub") retrofit: Retrofit):GithubService{
        return retrofit.create(GithubService::class.java)
    }
}