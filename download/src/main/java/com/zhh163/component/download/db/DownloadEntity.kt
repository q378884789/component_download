package com.zhh163.component.download.db

class DownloadEntity {

    var url: String? = null
    var path: String? = null
    var status: Int? = null
    var progress: Int? = null
    var size: Long? = null

    constructor(url: String?, path: String?, status: Int?, progress: Int?, size: Long?) {
        this.url = url
        this.path = path
        this.status = status
        this.progress = progress
        this.size = size
    }

    override fun toString(): String {
        return "DownloadEntity(url=$url, path=$path, status=$status, progress=$progress, size=$size)"
    }

}