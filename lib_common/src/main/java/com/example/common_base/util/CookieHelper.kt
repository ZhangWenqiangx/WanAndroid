package com.example.common_base.util

import com.example.common_base.constants.Constants.FILE_NAME

/**
 *  author : zhang.wenqiang
 *  date : 2021/9/9
 *  description :
 */
object CookieHelper {

    fun getDefCookie(): String {
        val spDomain = SpUtil.read(FILE_NAME, "www.wanandroid.com", "")
        return if (spDomain.isNotEmpty()) spDomain else ""
    }

    fun getDefCookieMap(): MutableMap<Any, Any> {
        return hashMapOf("result" to getDefCookie())
    }

    fun encodeCookie(cookies: List<String>): String {
        val sb = StringBuilder()
        val set = HashSet<String>()
        cookies
            .map { cookie ->
                cookie.split(";".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            }
            .forEach { it ->
                it.filterNot { set.contains(it) }.forEach { set.add(it) }
            }
        val ite = set.iterator()
        while (ite.hasNext()) {
            val cookie = ite.next()
            sb.append(cookie).append(";")
        }
        val last = sb.lastIndexOf(";")
        if (sb.length - 1 == last) {
            sb.deleteCharAt(last)
        }
        return sb.toString()
    }

    fun saveCookie(url: String?, domain: String?, cookies: String) {
        url ?: return
        SpUtil.write(FILE_NAME, url, cookies)
        domain ?: return
        SpUtil.write(FILE_NAME, domain, cookies)
    }

    fun clearCookie() {
        SpUtil.clear(FILE_NAME)
    }
}