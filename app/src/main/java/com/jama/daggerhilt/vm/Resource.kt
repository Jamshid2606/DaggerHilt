package com.jama.daggerhilt.vm

sealed class Resource<T> {
    class Loading<T> : Resource<T>()
    class Success<T:Any>(val data:T) : Resource<T>()
    class Error<T:Any>(val t:Throwable) : Resource<T>()
}