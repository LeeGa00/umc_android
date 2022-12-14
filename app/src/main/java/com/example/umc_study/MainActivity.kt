package com.example.umc_study

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.umc_study.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMainBinding

    private var memoTitle:String = ""
    private var memoContents:String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.sendButton.setOnClickListener {
            if(viewBinding.title.length() == 0 || viewBinding.memoContent.length() == 0){
                Toast.makeText(this, "입력하지 않은 정보가 있습니다.", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("title", viewBinding.title.text.toString())
                intent.putExtra("content", viewBinding.memoContent.text.toString())
                setResult(RESULT_OK, intent)
                finish()
            }
        }
    }

    override fun onPause() {
        super.onPause()
        memoTitle = viewBinding.title.text.toString()
        memoContents = viewBinding.memoContent.text.toString()
    }

    override fun onResume() {
        super.onResume()
        viewBinding.title.setText(memoTitle)
        viewBinding.memoContent.setText(memoContents)
    }

    override fun onRestart() {
        super.onRestart()
        val builder = AlertDialog.Builder(this)
        builder.setTitle("선택창")
            .setMessage("이어서 작성하시겠습니까?")
            .setPositiveButton("Yes",
            DialogInterface.OnClickListener{dialog, id ->
                viewBinding.title.setText(memoTitle)
                viewBinding.memoContent.setText(memoContents)
                Toast.makeText(this, "이어서 작성", Toast.LENGTH_SHORT).show()
            })
            .setNegativeButton("No",
            DialogInterface.OnClickListener{dialog, id ->
                memoTitle = ""
                memoContents = ""
                viewBinding.title.setText(memoTitle)
                viewBinding.memoContent.setText(memoContents)
                Toast.makeText(this, "새로 작성", Toast.LENGTH_SHORT).show()
            })
        builder.show()
    }
}
