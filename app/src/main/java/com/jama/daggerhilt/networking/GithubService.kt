package com.jama.daggerhilt.networking

import com.jama.daggerhilt.models.github.GithubUser
import retrofit2.http.GET

interface GithubService {
    @GET("users")
    suspend fun getGithubUsers():List<GithubUser>
}