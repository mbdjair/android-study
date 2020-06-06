package com.djair.chucknorris.presentation.adapter

import android.view.View
import androidx.databinding.BindingAdapter

object VisibilityAdapter {
    @JvmStatic
    @BindingAdapter("android:visibility")
    fun setVisibility(view: View, value: Boolean) {
        view.visibility = if (value) View.VISIBLE else View.GONE
    }
}