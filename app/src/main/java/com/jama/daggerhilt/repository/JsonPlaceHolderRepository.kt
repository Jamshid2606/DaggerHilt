package com.jama.daggerhilt.repository

import com.jama.daggerhilt.networking.JsonPlaceHolderService
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class JsonPlaceHolderRepository @Inject constructor(
    private val jsonPlaceHolderService: JsonPlaceHolderService
) {
    fun getJsonPlaceHolderUsers() = flow{
        emit(jsonPlaceHolderService.getJsonPlaceHolderUsers())
    }
}