package com.example.umc_study

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.netflix_3)

        val activityChangeBtn = findViewById<Button>(R.id.home_bottom_gameBtn)

        activityChangeBtn.setOnClickListener {
            startActivity(Intent(this@MainActivity, SubActivity::class.java))
        }
    }
}
