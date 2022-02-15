package com.example.exam_class

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

class BindingAdapter1 {
    companion object {
        @JvmStatic
        @BindingAdapter("Image")
        fun loadImage(view: ImageView, url: String) {
            Glide.with(view.context)
                .load(url)
                .into(view)
        }
    }
}