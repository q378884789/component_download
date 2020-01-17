package com.zhh163.component.download

interface DownloadListener {

    /**
     * 下载进度
     * @param process 进度
     * @param url 下载的URL
     */
    fun onDownload(url: String, process: Float)

    /**
     * 下载成功
     * @param filePath 文件下载的路径
     */
    fun onSuccess(filePath: String)

    /**
     * 下载出错
     * @param errorCode 错误代码
     * @param errorMsg 错误信息
     */
    fun onError(url: String, errorCode: Int, errorMsg: String)

}