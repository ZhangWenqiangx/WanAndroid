package com.example.module_home.data.source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.module_home.search.bean.SearchEntity

/**
 *  @author : zhang.wenqiang
 *  @date : 2020/12/9
 *  description :
 */
@Database(entities = [SearchEntity::class], version = 1,exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun searchDao(): SearchDao
}
