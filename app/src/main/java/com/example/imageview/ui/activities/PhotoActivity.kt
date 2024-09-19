package com.example.imageview.ui.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.imageview.R
import com.example.imageview.ui.viewModel.PhotoViewModel

class PhotoActivity : AppCompatActivity() {
    private lateinit var nextButton: Button
    private lateinit var imageView: ImageView
    private val viewModel: PhotoViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo)

        nextButton = findViewById(R.id.nextButton)
        imageView = findViewById(R.id.imageView)

        imageView.clipToOutline = true

        viewModel.currentPhoto.observe(this, Observer { photo ->
            imageView.setImageResource(photo.resourceId)
        })

        nextButton.setOnClickListener {
            if (viewModel.isLastPhoto()) {
                val intent = Intent(this, FinalActivity::class.java)
                startActivity(intent)
            } else {
                viewModel.nextPhoto()
            }
        }
    }
}
