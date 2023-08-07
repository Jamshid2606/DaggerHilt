package com.jama.daggerhilt.networking

import com.jama.daggerhilt.models.jsonplaceholder.JsonPlaceHolderUsers
import retrofit2.http.GET

interface JsonPlaceHolderService {
    @GET("users")
    suspend fun getJsonPlaceHolderUsers():List<JsonPlaceHolderUsers>
}