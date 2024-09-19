package com.example.imageview.ui.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.imageview.R

class MainActivity : AppCompatActivity() {
    private lateinit var startButton: Button
    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startButton = findViewById(R.id.startButton)
        imageView = findViewById(R.id.startImageView)

        imageView.setImageResource(R.drawable.preview)
        imageView.clipToOutline = true

        startButton.setOnClickListener {
            val intent = Intent(this, PhotoActivity::class.java)
            startActivity(intent)
        }
    }
}
