package com.example.module_home.search.bean

data class SearchResult(
    val author: String,
    val shareUser: String,
    val link: String,
    val niceDate: String,
    val chapterName: String,
    val superChapterName: String,
    val title: String,
    val collect: Boolean
)