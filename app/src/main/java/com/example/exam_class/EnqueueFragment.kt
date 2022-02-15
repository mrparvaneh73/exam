package com.example.exam_class

import android.app.Activity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_enqueue.*
import okhttp3.*
import java.io.IOException

class EnqueueFragment:Fragment(R.layout.fragment_enqueue) {
   private val handlerThread by lazy { Handler(Looper.getMainLooper()) }
    private val client by lazy { OkHttpClient() }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val request= Request.Builder().url("https://github.com/mrparvaneh73").build()
        val newcall=client.newCall(request)
        newcall.enqueue(object:Callback {
            override fun onFailure(call: Call, e: IOException) {
              set(e.message)
            }

            override fun onResponse(call: Call, response: Response) {
              set(response.body()?.string())
            }

        })
    }
    private fun set(data:String?){
        Handler(Looper.getMainLooper()).post{
            tv_enqueue.text=data
        }
    }
}