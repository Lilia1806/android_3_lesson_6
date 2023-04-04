package com.example.android_3_lesson_6.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import com.example.android_3_lesson_6.R

abstract class BaseFragment<VB : ViewBinding, VM : ViewModel>(@LayoutRes layoutId: Int) :
    Fragment(layoutId) {

    abstract val binding: VB
    abstract val viewModel: VM

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupListeners()
        setupCollect()
    }

    protected open fun initialize() {}

    protected open fun setupListeners() {}

    protected open fun setupCollect() {}

}