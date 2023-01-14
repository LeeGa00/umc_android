package com.example.newmemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.newmemo.databinding.ActivityCreateMemoBinding

class CreateMemo : AppCompatActivity() {
    private val viewModel: NewMemo by viewModels()
    private lateinit var binding: ActivityCreateMemoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_create_memo)
        binding.lifecycleOwner = this
    }
}