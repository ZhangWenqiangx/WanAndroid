package com.example.common_base.http

import android.net.ParseException
import android.os.Handler
import android.os.Looper
import com.example.common_base.base.BaseApplication
import com.example.common_base.util.ToastUtil
import com.google.gson.JsonParseException
import org.apache.http.conn.ConnectTimeoutException
import org.json.JSONException
import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketTimeoutException
import javax.net.ssl.SSLHandshakeException

/**
 * Description:关于请求数据异常的处理.
 */
class ExceptionHandler {

    companion object {

        lateinit var errorMsg: String

        val mainHandler by lazy { Handler(Looper.getMainLooper()) }

        @JvmStatic
        fun handlerException(e: Throwable): Throwable {
            errorMsg = when (e) {
                is HttpException -> "网络错误"
                is ApiException -> "服务端出错/" + e.errcode + "/" + e.errmsg    //自己定义关于服务器返回code的处理
                is JsonParseException -> "解析出错"
                is JSONException -> "解析出错"
                is ParseException -> "解析出错"
                is ConnectException -> "网络连接失败,请稍后重试"
                is SSLHandshakeException -> {
                    e.printStackTrace()
                    "证书验证失败"
                }
                is ConnectTimeoutException -> "网络连接超时"
                is SocketTimeoutException -> "网络连接超时"
                else -> "网络连接异常,请稍后重试"
            }
            mainHandler.post {
                ToastUtil.showToast(BaseApplication.sApplication, errorMsg)
            }
            return e
        }
    }
}