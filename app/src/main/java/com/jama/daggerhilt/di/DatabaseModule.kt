package com.jama.daggerhilt.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.jama.daggerhilt.database.AppDatabase
import com.jama.daggerhilt.database.dao.GithubUserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase{
        return Room.databaseBuilder(context,AppDatabase::class.java, "my_db")
            .fallbackToDestructiveMigration()
            .build()
    }
    @Provides
    @Singleton
    fun provideGithubUserDao(appDatabase: AppDatabase):GithubUserDao{
        return appDatabase.getGithubUserDao()
    }
}