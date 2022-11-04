package com.example.umc_study

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.umc_study.databinding.ActivitySwitchRvBinding

class SwitchRvActivity: AppCompatActivity() {
    private lateinit var viewBinding: ActivitySwitchRvBinding
    private val dataList: ArrayList<MemoData> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivitySwitchRvBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        dataList.apply {
            add(MemoData("1", "switch1"))
            add(MemoData("2", "switch2"))
            add(MemoData("3", "switch3"))
            add(MemoData("4", "switch4!"))
            add(MemoData("5", "switch5"))
            add(MemoData("6", "switch6"))
            add(MemoData("7", "switch7"))
            add(MemoData("8", "switch8"))
            add(MemoData("9", "switch9"))
            add(MemoData("10", "switch10"))
            add(MemoData("11", "switch11"))
            add(MemoData("12", "switch12"))
            add(MemoData("13", "switch13"))
            add(MemoData("14", "switch14"))
            add(MemoData("15", "switch15"))
            add(MemoData("16", "switch16"))
            add(MemoData("17", "switch17"))
            add(MemoData("18", "switch18"))
            add(MemoData("19", "switch19"))
            add(MemoData("20", "switch20"))
        }

        val switchRVAdapter = SwitchRVAdapter(dataList)

        viewBinding.rvSwitchBox.adapter = switchRVAdapter
        viewBinding.rvSwitchBox.layoutManager = LinearLayoutManager(this)
    }
}