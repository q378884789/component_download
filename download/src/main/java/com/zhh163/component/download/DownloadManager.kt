package com.zhh163.component.download

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.RandomAccessFile
import java.util.concurrent.TimeUnit

class DownloadManager constructor() {

    companion object {
        const val TAG = "DownloadManager"
    }

    private var builder: OkHttpClient.Builder
    private var okHttpClient: OkHttpClient

    private var mListener: DownloadListener? = null

    init {
        Log.i(TAG, "DownloadManager init")
        builder = OkHttpClient.Builder()
        builder.retryOnConnectionFailure(true)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS)

        okHttpClient = builder.build();
    }

    /**
     * 设置下载监听事件
     * @param listener 监听下载事件
     */
    fun setDownloadListener(listener: DownloadListener) {
        this.mListener = listener
    }

    /**
     * 开始下载
     * @param url 下载地址
     * @param savePath 保存的路径
     */
    fun startDownload(url: String, savePath: String) {
        Log.i(TAG, " 下载路径: $url")
        val request = Request.Builder().url(url).build()

        val execute = okHttpClient.newCall(request).execute()
        if (execute != null && execute.isSuccessful) {
            val length = execute.body().contentLength()
            Log.i(TAG, "下载的文件大小为 $length")

            writeFile(execute, length, savePath)
        }
    }

    private fun writeFile(response: Response, totalSize: Long, savePath: String) {
        val buf = ByteArray(2048)
        val file = RandomAccessFile(savePath, "rw")

        val bs = response.body().byteStream()
        while (true) {
            val len = bs.read(buf)
            if (len == -1) {
                break
            }
            file.write(buf, 0, len);
        }
        Log.i(TAG, "文件 $savePath 下载完成");
        mListener?.onSuccess(savePath)
    }

}