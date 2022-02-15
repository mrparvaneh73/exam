package com.example.exam_class

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_execute.*
import okhttp3.Call
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException
import java.util.concurrent.Callable
import java.util.concurrent.Executors
import java.util.concurrent.Future

class ExecuteFragment:Fragment(R.layout.fragment_execute) {
    private val client by lazy { OkHttpClient() }
    private val handlerThread by lazy { Handler(Looper.getMainLooper()) }
    private val exacuter by lazy { Executors.newSingleThreadExecutor() }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val request= Request.Builder().url("https://github.com/mrparvaneh73").build()
        try {
             exacuter.execute{
                val response = client.newCall(request).execute()
                val responsebody =response.body()
                 handlerThread.post{
                     tv_execute.text=responsebody?.string()
                 }
            }

        }catch (e: IOException){
            tv_execute.text=e.javaClass.simpleName+e.message
        }

    }
}