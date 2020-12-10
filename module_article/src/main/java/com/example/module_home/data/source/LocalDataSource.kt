package com.example.module_home.data.source

import com.example.common_base.base.data.viewmodel.BaseDataOperate
import com.example.common_base.base.data.BaseResult
import com.example.module_home.search.bean.SearchEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext

/**
 * @describe : 数据库相关操作
 *
 * @author zwq 2020/11/23
 */
class LocalDataSource(private val dao: SearchDao) : BaseDataOperate() {

    suspend fun saveKey(key: String) {
        coroutineScope {
            dao.insert(search = SearchEntity(key))
        }
    }

    suspend fun getAllHistory(): BaseResult<MutableList<SearchEntity>> =
        withContext(Dispatchers.IO) {
            return@withContext try {
                BaseResult.Success(data = dao.getAll())
            } catch (e: Exception) {
                BaseResult.Error(e)
            }
        }

    suspend fun deleteHistory() {
        coroutineScope {
            dao.deleteAll()
        }
    }

    suspend fun deleteHistory(data: SearchEntity) {
        coroutineScope {
            dao.delete(data.key)
        }
    }
}