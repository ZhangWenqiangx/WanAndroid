package com.example.module_home.home.bean

data class Article(
    val id: Int,
    val title: String,
    val author: String,
    val niceShareDate: String,
    val superChapterName: String,
    val envelopePic: String,
    val link: String,
    val desc: String,
    val fresh: Boolean,
    val shareUser:String,
    val collect: Boolean,
    val type: Int
)