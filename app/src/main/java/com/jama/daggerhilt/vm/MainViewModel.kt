package com.jama.daggerhilt.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jama.daggerhilt.models.MainUser
import com.jama.daggerhilt.models.jsonplaceholder.JsonPlaceHolderUsers
import com.jama.daggerhilt.repository.GithubRepository
import com.jama.daggerhilt.repository.JsonPlaceHolderRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val jsonPlaceHolderRepository: JsonPlaceHolderRepository,
    private val githubRepository: GithubRepository
):ViewModel() {
    private val _flow = MutableStateFlow<Resource<MainUser>>(Resource.Loading())
    val flow get() = _flow

    init {
        getJsonPlaceHolderUsers()
    }

    private fun getJsonPlaceHolderUsers(){
        viewModelScope.launch {
            combine(jsonPlaceHolderRepository.getJsonPlaceHolderUsers(), githubRepository.getGithubUsers()
            ) { jsonPlaceHolderUsers, githubUsers->
                _flow.emit(Resource.Success(MainUser(jsonPlaceHolderUsers, githubUsers)))
            }.catch {
                _flow.emit(Resource.Error(it))
            }.collect{

            }

//            jsonPlaceHolderRepository.getJsonPlaceHolderUsers()
//                .catch {
//                    _flow.emit(Resource.Error(it))
//                }
//                .collect{
//                    _flow.emit(Resource.Success(it))
//                }
        }
    }
}