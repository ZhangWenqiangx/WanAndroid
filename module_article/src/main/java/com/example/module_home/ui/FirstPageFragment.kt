package com.example.module_home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.module_home.FirstPageAdapter
import com.example.module_home.FirstPageViewModel
import com.example.module_home.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_first_page.*

/**
 * 文章首页
 */
@AndroidEntryPoint
class FirstPageFragment : Fragment() {

    private lateinit var adapter: FirstPageAdapter

    private val viewModel by viewModels<FirstPageViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_first_page, container, false)
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        adapter = FirstPageAdapter(R.layout.item_home_recycler)
        adapter.loadMoreModule.apply {}
        rv_content.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = adapter
        }

        viewModel.articles.observe(viewLifecycleOwner, Observer {
            adapter.loadMoreModule.loadMoreComplete()
            adapter.setNewInstance(it)
        })
        viewModel.getArticles(1)
    }
}