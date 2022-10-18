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

    private var memoContents:String = ""

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

    override fun onResume() {
        super.onResume()
        viewBinding.memoContent.setText(memoContents)
    }

    override fun onRestart() {
        super.onRestart()
        val builder = AlertDialog.Builder(this)
        builder.setTitle("선택창")
            .setMessage("이어서 작성하시겠습니까?")
            .setPositiveButton("Yes",
            DialogInterface.OnClickListener{dialog, id ->
                viewBinding.memoContent.setText(memoContents)
                Toast.makeText(this, "이어서 작성", Toast.LENGTH_SHORT).show()
            })
            .setNegativeButton("No",
            DialogInterface.OnClickListener{dialog, id ->
                memoContents = ""
                viewBinding.memoContent.setText(memoContents)
                Toast.makeText(this, "새로 작성", Toast.LENGTH_SHORT).show()
            })
        builder.show()
    }
}
