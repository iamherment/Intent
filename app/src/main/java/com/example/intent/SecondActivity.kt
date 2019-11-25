package com.example.intent

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val msg=intent.getStringExtra(MainActivity.EXTRA_MSG)
        val lcky=intent.getStringExtra(MainActivity.EXTRA_LUCKY)
        txtMsgView.text=String.format("%s %s ","Message :",msg+lcky)
        btnDone.setOnClickListener {

            intent =getIntent()

            if(!edtTxt2.text.isEmpty()){
            val reply=edtTxt2.text.toString()
                intent.putExtra(MainActivity.EXTRA_REPLY,reply)
                setResult(Activity.RESULT_OK,intent)
            }
            else{
                setResult(Activity.RESULT_CANCELED)
            }
            finish()
        }
    }
}
