package com.example.module_home.search.bean

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

/**
 *  @author : zhang.wenqiang
 *  @date : 2020/12/9
 *  description :
 */
@Entity
data class SearchEntity(
    @ColumnInfo(name = "key") var key: String = "",
    @PrimaryKey @ColumnInfo(name = "entryid") var id: String = UUID.randomUUID().toString()
)