package com.jama.daggerhilt.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jama.daggerhilt.database.dao.GithubUserDao
import com.jama.daggerhilt.database.entity.GithubUserEntity

@Database(entities = [GithubUserEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getGithubUserDao():GithubUserDao
}