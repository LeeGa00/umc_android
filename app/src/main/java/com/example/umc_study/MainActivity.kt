package com.example.umc_study

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.umc_study.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMainBinding

    var memoContents:String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.sendButton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("main_text", viewBinding.memoContent.text.toString())
            startActivity(intent)
        }
    }

    override fun onPause() {
        super.onPause()
        memoContents = viewBinding.memoContent.text.toString()
    }

    override fun onRestart() {
        super.onRestart()
    }

}
