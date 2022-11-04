package com.example.umc_study

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.umc_study.databinding.ActivitySecondBinding


class SecondActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivitySecondBinding
    private val dataList: ArrayList<MemoData> = arrayListOf()
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        dataList.apply {
            add(MemoData("memo1", "first memo!"))
            add(MemoData("memo2", "second memo!"))
            add(MemoData("memo3", "third memo!"))
            add(MemoData("memo4", "memo!"))
            add(MemoData("memo5", "memo!"))
            add(MemoData("memo6", "memo!"))
            add(MemoData("memo7", "memo!"))
            add(MemoData("memo8", "memo!"))
            add(MemoData("memo9", "memo!"))
            add(MemoData("memo10", "memo!"))
            add(MemoData("memo11", "memo!"))

        }

        val memoDataRVAdapter = MemoDataRVAdapter(dataList)

        viewBinding.rvMemoBox.adapter = memoDataRVAdapter
        viewBinding.rvMemoBox.layoutManager = LinearLayoutManager(this)

        memoDataRVAdapter.setMyItemClickListener(object: MemoDataRVAdapter.MyItemClickListener {
            override fun onItemClick(memo: MemoData) {

            }

            override fun onRemoveMemo(position: Int) {
                memoDataRVAdapter.removeItem(position)
            }
        })

        fun setNewMemo(){
            resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
                if (result.resultCode == Activity.RESULT_OK){
                    val title = result.data?.getStringExtra("title") ?: ""
                    val content = result.data?.getStringExtra("content")?:""

                    memoDataRVAdapter.addItem(title, content)
                }
            }
        }

        setNewMemo()

        viewBinding.btnNewMemo.setOnClickListener(){
            val intent = Intent(this, MainActivity::class.java)
            resultLauncher.launch(intent)
        }
    }
}