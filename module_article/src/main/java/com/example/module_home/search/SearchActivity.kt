package com.example.module_home.search

import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import com.example.common_base.base.BaseActivity
import com.example.common_base.widget.SearchableView
import com.example.module_home.R
import com.example.module_home.ViewModelCreater
import kotlinx.android.synthetic.main.activity_search.*


class SearchActivity : BaseActivity() {
    override fun getLayoutResId(): Int = R.layout.activity_search

    protected val viewModel by lazy {
        ViewModelProvider(this, ViewModelCreater()).get(SearchViewModel::class.java)
    }

    override fun initView() {

        tv_cancle.setOnClickListener { finish() }

        search_input.apply {
            setIconifiedByDefault(false)
            queryHint = getString(R.string.str_input_key)

            setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    selectFragment(1)
                    viewModel.searchKey.value = query
                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    return false
                }
            })

            setOnCloseClickListener(object : SearchableView.OnCloseClickListener {
                override fun onClose() {
                    viewModel.clearSearchData()
                    selectFragment(0)
                }
            })
        }

        fm = supportFragmentManager
        createFragment()
        selectFragment(0)
    }

    fun onHotKeyClick(it: String) {
        selectFragment(1)
        search_input.setQuery(it, false)
        viewModel.searchByKey(it, true)
        viewModel.searchKey.value = it
    }

    private lateinit var fm: FragmentManager
    private var fragments = mutableListOf<Fragment>()

    private fun selectFragment(index: Int) {
        val ft = fm.beginTransaction()
        for (i in fragments.indices) {
            if (i == index) {
                ft.show(fragments[i])
            } else {
                ft.hide(fragments[i])
            }
        }
        ft.commit()
    }

    private fun createFragment() {
        val transaction = fm.beginTransaction()
        val hotKeyFragment = HotKeyFragment.newInstance()
        val searchResultFragment = SearchResultFragment.newInstance()

        transaction.apply {
            add(R.id.fl_content, hotKeyFragment)
            add(R.id.fl_content, searchResultFragment)
        }

        fragments.apply {
            add(hotKeyFragment)
            add(searchResultFragment)
        }

        transaction.commit()
    }

    override fun initData() {
        viewModel.getHotKey()
    }
}