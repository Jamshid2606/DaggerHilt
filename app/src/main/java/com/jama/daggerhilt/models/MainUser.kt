package com.jama.daggerhilt.models

import com.jama.daggerhilt.models.github.GithubUser
import com.jama.daggerhilt.models.jsonplaceholder.JsonPlaceHolderUsers

data class MainUser(
    val jsonPlaceHolderUsers: List<JsonPlaceHolderUsers>,
    val githubUser: List<GithubUser>
)