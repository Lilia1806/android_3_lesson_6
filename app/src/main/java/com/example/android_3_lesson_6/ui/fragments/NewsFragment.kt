package com.example.android_3_lesson_6.ui.fragments

import android.util.Log
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android_3_lesson_6.R
import com.example.android_3_lesson_6.base.BaseFragment
import com.example.android_3_lesson_6.databinding.FragmentNewsBinding
import com.example.android_3_lesson_6.ui.adapter.NewsAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class NewsFragment :
    BaseFragment<FragmentNewsBinding, NewsViewModel>(R.layout.fragment_news) {

    override val binding by viewBinding(FragmentNewsBinding::bind)
    override val viewModel: NewsViewModel by viewModels()
    private var newsAdapter = NewsAdapter()

    override fun initialize() {
        binding.topheadlinesRecycler.adapter = newsAdapter
            Toast.makeText(requireContext(), "text", Toast.LENGTH_SHORT).show()
    }

    override fun setupCollect() {
        lifecycleScope.launch {
            viewModel.fetchNews().collect {
                lifecycleScope.launch {
                    Log.e("error", it.toString())
                newsAdapter.submitData(it)
            }
            }
        }
    }
}