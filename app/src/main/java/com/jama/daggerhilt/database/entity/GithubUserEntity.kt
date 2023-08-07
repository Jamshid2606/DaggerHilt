package com.jama.daggerhilt.database.entity

import androidx.room.Entity

@Entity
data class GithubUserEntity(
    val id:Int,
    val avatar:String,
    val login:String
)
