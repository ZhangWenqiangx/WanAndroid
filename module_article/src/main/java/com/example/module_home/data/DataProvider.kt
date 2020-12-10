package com.example.module_home.data

import android.content.Context
import androidx.annotation.VisibleForTesting
import androidx.room.Room
import com.example.module_home.data.source.AppDatabase
import com.example.module_home.data.source.LocalDataSource
import com.example.module_home.data.source.RemoteDataSource
import com.example.module_home.data.source.SearchDao

/**
 *  @author : zhang.wenqiang
 *  @date : 2020/12/10
 *  description : 提供repository
 *   remote 网络请求获取数据
 *   local   本地请求数据Room
 */
object DataProvider {

    @Volatile
    var articleRepository: ArticleRepository? = null
        @VisibleForTesting set

    fun provideRepository(context: Context): ArticleRepository {
        synchronized(this) {
            return articleRepository ?: articleRepository ?: createRepository(context)
        }
    }

    private fun createRepository(context: Context): ArticleRepository {
        val newRepo = DefaultArticleRepository(
            LocalDataSource(providerDao(context)), RemoteDataSource()
        )
        articleRepository = newRepo
        return newRepo
    }

    private fun providerDao(context: Context): SearchDao {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java, "search_value"
        ).build().searchDao()
    }
}