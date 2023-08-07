package com.jama.daggerhilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.jama.daggerhilt.vm.MainViewModel
import com.jama.daggerhilt.vm.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val mainViewModel:MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lifecycleScope.launch {
            mainViewModel.flow
                .collect{
                    when(it){
                        is Resource.Success->{
                            Toast.makeText(this@MainActivity, "JSONPLACEHOLDERUSER [0]- ${it.data.jsonPlaceHolderUsers[0].phone}", Toast.LENGTH_SHORT).show()
                            Toast.makeText(this@MainActivity, "GITHUBUSER [0]- ${it.data.githubUser[0].login}", Toast.LENGTH_SHORT).show()
                        }
                        is Resource.Error->{

                        }
                        is Resource.Loading->{

                        }
                    }
                }
        }
    }
}