package com.zhh163.component.download

class DownloadStatus {

    companion object {
        const val STATUS_PREPARE = 1                               //准备下载
        const val STATUS_START = STATUS_PREPARE + 1                   //开始下载
        const val STATUS_DOWNLOADING = STATUS_PREPARE + 2             //正在下载
        const val STATUS_PAUSE = STATUS_PREPARE + 3                   //暂停下载
        const val STATUS_DOWNLOADED = STATUS_PREPARE + 4              //下载完成
        const val STATUS_ERROR = STATUS_PREPARE + 5                   //下载出错
    }

}