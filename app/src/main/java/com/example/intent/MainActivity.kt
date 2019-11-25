package com.example.intent

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSend.setOnClickListener {
            sendMsg()
        }
    }

    private fun sendMsg() {
        if(edtMsg.text.isEmpty()){
            edtMsg.setError("Value required")
            edtLcky.setError("Value required")

            return
        }
        else{
            val intent= Intent(this,SecondActivity::class.java)

            val message=edtMsg.text.toString()
            val lucky=edtLcky.text.toString()
            intent.putExtra(EXTRA_MSG,message)
            intent.putExtra(EXTRA_LUCKY,lucky)

            //startActivity(intent)
            startActivityForResult(intent,REQUEST_CODE)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode== REQUEST_CODE){
            if(resultCode== Activity.RESULT_OK){
                val reply =data?.getStringExtra(EXTRA_REPLY)
                txtViewReply.text=reply
            }

        }
    }

    companion object{
        const val  EXTRA_MSG="com.example.intent.EXTRA_MSG"
        const val EXTRA_LUCKY="com.example.intent.EXTRA_LUCKY"
        const val EXTRA_REPLY="com.example.intent.EXTRA.REPLY"
        const val REQUEST_CODE=1

    }
}
