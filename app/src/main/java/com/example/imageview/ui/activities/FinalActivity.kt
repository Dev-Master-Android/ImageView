package com.example.imageview.ui.activities

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.imageview.R

class FinalActivity : AppCompatActivity() {
    private lateinit var finishButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final)

        finishButton = findViewById(R.id.finishButton)
        finishButton.setOnClickListener {
            finishAffinity() // Завершает все активити в стеке задач
        }
    }
}
