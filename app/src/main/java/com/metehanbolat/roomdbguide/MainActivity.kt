package com.metehanbolat.roomdbguide

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.metehanbolat.roomdbguide.database.User
import com.metehanbolat.roomdbguide.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        viewModel.readAllData.observe(this) {
            println("readAllData User: $it")
        }

        viewModel.readAllDataLikeLiveData.observe(this) {
            println("readAllDataLikeLiveData: $it")
        }

        binding.button.setOnClickListener {
            val user = User(
                id = 0,
                firstName = "Metehan",
                lastName = "Bolat",
                age = 24
            )
            viewModel.addUser(user = user)
        }
    }
}