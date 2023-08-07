package com.jama.daggerhilt.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jama.daggerhilt.database.entity.GithubUserEntity
import com.jama.daggerhilt.models.github.GithubUser

@Dao
interface GithubUserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addUsers(list: List<GithubUserEntity>)

    @Query("select * from githubuserentity")
    fun getGithubUsers() : List<GithubUserEntity>
}