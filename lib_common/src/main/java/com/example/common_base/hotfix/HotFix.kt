package com.example.common_base.hotfix

import android.content.Context
import dalvik.system.BaseDexClassLoader
import dalvik.system.DexClassLoader
import java.io.File
import java.lang.reflect.Array


/**
 *  @author : zhang.wenqiang
 *  @date : 2021/3/2
 *  description : 把补丁 dex ⽂件加载放进⼀个 Element，并且插入到 dexElements 这个数组的前⾯
 */
object HotFix {
    fun init(context: Context) {
        context.run {
            val hotfixDex = File("$cacheDir/hotfix.apk")
//            if (!hotfixDex.exists()) {
//                try {
//                    assets.open("hotfix.apk").source().use { source ->
//                        hotfixDex.sink().buffer().use { sink -> sink.writeAll(source) }
//                    }
//                } catch (e: IOException) {
//                    e.printStackTrace()
//                }
//            }
            if (hotfixDex.exists()) {
                /** 获取到hotfix的delxElements pathlist */
                //先加载Dex 然后反射获取hotfix的Classloader的pathList对象
                val hotfixDexClassLoader = DexClassLoader(hotfixDex.path, cacheDir.path, null, null)
                val pathListField = BaseDexClassLoader::class.java.getDeclaredField("pathList")
                pathListField.isAccessible = true
                val hotfixPathListObj = pathListField.get(hotfixDexClassLoader)

                //反射获取pathList对象中的dexElements对象 包含了dex文件
                val hotfixPathListClass = hotfixPathListObj::class.java
                val dexElementsField = hotfixPathListClass.getDeclaredField("dexElements")
                dexElementsField.isAccessible = true
                val hotfixDexElementsObject = dexElementsField[hotfixPathListObj]

                /** 获取到原始的delxElements*/
                //获取源Classloader的pathList对象
                val originalPathListObject = pathListField.get(classLoader)
                //获取Element数组中源DexElements对象
                val originalDexElementsObject = dexElementsField[originalPathListObject]

                /**  */
                //将hotfix的dexElements放在前面  源放在后面  先加载新的 就不会加载旧的
                val oldLength: Int = Array.getLength(originalDexElementsObject!!)
                val newLength: Int = Array.getLength(hotfixDexElementsObject!!)
                //包含新的和旧的
                val concatDexElementsObject: Any = Array.newInstance(
                    hotfixDexElementsObject::class.java.componentType!!,
                    oldLength + newLength
                )
                for (i in 0 until newLength) {
                    Array.set(concatDexElementsObject, i, Array.get(hotfixDexElementsObject, i))
                }
                for (i in 0 until oldLength) {
                    Array.set(
                        concatDexElementsObject,
                        newLength + i,
                        Array.get(originalDexElementsObject, i)
                    )
                }
                //替换
                dexElementsField[originalPathListObject] = concatDexElementsObject
            }
        }
    }
}