package com.metehanbolat.roomdbguide

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import coil.ImageLoader
import coil.request.ImageRequest
import coil.request.SuccessResult
import com.metehanbolat.roomdbguide.database.Parent
import com.metehanbolat.roomdbguide.database.User
import com.metehanbolat.roomdbguide.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
/*
        viewModel.readAllData.observe(this) {
            println("readAllData User: $it")
        }

 */

        viewModel.readAllDataLikeLiveData.observe(this) {
            println("readAllDataLikeLiveData: $it")
            if (it.isNotEmpty()) {
                binding.image.setImageBitmap(it[0].profilePhoto)
            }
        }

        binding.button.setOnClickListener {
            lifecycleScope.launch {
                val user = User(
                    firstName = "John",
                    lastName = "Doe",
                    age = 24,
                    profilePhoto = getBitmap(),
                    parent = Parent(
                        motherName = "Jessica",
                        fatherName = "Alex"
                    )
                )
                viewModel.addUser(user = user)
            }
        }
    }

    private suspend fun getBitmap(): Bitmap {
        val loading = ImageLoader(this)
        val request = ImageRequest.Builder(this)
            .data("https://raw.githubusercontent.com/metehanie/RoomDBGuide/master/avatar.jpg")
            .build()
        val result = (loading.execute(request) as SuccessResult).drawable
        return (result as BitmapDrawable).bitmap

    }
}