package com.example.common_base.glide

import okhttp3.ResponseBody
import okio.*

/**
 *  author : zhang.wenqiang
 *  date : 2021/9/15
 *  description :contentLength 和 已读取到的流字节数 来计算当前进度值
 */
class ProgressResponseBody(
    private val originResponseBody: ResponseBody,
    url: String
) : ResponseBody() {

    private var mListener = ProgressInterceptor.getListener(url)

    override fun contentLength() = originResponseBody.contentLength()

    override fun contentType() = originResponseBody.contentType()

    override fun source(): BufferedSource = object : ForwardingSource(originResponseBody.source()) {
        private var totalBytesRead = 0L
        private var currentProgress = 0

        override fun read(sink: Buffer, byteCount: Long): Long {
            return super.read(sink, byteCount).apply {
                if (this == -1L) {
                    totalBytesRead = contentLength()
                } else {
                    totalBytesRead += this
                }
                val progress = (100F * totalBytesRead / contentLength()).toInt()
                if (progress != currentProgress) {
                    currentProgress = progress
                    mListener?.onProgress(currentProgress)
                }
                if (totalBytesRead == contentLength()) {
                    mListener = null
                }
            }
        }
    }.buffer()
}