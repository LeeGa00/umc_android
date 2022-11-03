package com.example.umc_study

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.umc_study.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        //val extras = intent.extras
        //val data = extras!!["main_text"] as String
        //viewBinding.getText.text = data

        //viewBinding.moveButton.setOnClickListener {
        //    val intent = Intent(this, ThirdActivity::class.java)
        //    startActivity(intent)
        //}

        val dataList: ArrayList<MemoData> = arrayListOf()

        dataList.apply {
            add(MemoData("memo1", "first memo!"))
            add(MemoData("memo2", "second memo!"))
            add(MemoData("memo3", "third memo!"))
        }

        val memoDataRVAdapter = MemoDataRVAdapter(dataList)

        viewBinding.rvMemoBox.adapter = memoDataRVAdapter
        viewBinding.rvMemoBox.layoutManager = LinearLayoutManager(this)
    }
}