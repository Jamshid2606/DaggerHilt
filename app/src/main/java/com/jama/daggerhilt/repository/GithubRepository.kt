package com.jama.daggerhilt.repository

import com.jama.daggerhilt.database.dao.GithubUserDao
import com.jama.daggerhilt.networking.GithubService
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GithubRepository @Inject constructor(
    private val githubService: GithubService,
    private val githubUserDao: GithubUserDao
) {
    fun getGithubUsers() = flow { emit(githubService.getGithubUsers()) }
}