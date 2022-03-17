package com.example.module_home.data.source

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.module_home.search.bean.SearchEntity

/**
 *  @author : zhang.wenqiang
 *  @date : 2020/12/9
 *  description :数据库操作
 */
@Dao
interface SearchDao {
    @Query("SELECT * FROM SearchEntity")
    fun getAll(): MutableList<SearchEntity>

    @Insert
    fun insert(search: SearchEntity)

    @Query("DELETE FROM SearchEntity")
    fun deleteAll()

    @Query("DELETE FROM SearchEntity WHERE `key` = :key")
    fun delete(key: String)
}
