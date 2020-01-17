package com.zhh163.component.download.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DownloadDBHelper : SQLiteOpenHelper {

    companion object {
        const val DOWNLOAD_DB: String = "download_db"
        const val DB_VERSION: Int = 1;

        const val sql =
            "create table if not exists " + DOWNLOAD_DB +
                    " (id INTEGER primary key, " +
                    DBFields.ID + " TEXT unique, " +
                    DBFields.DL_URL + " TEXT unique, " +
                    DBFields.DL_PROGRESS + " TEXT, " +
                    DBFields.DL_SIZE + " LONG, " +
                    DBFields.DL_PATH + " TEXT, " +
                    DBFields.DL_STATUS + " INTEGER" + ")"
    }

    @Volatile
    private var context: Context


    constructor(context: Context) : super(context, DOWNLOAD_DB, null, DB_VERSION) {
        this.context = context
    }

    override fun onCreate(db: SQLiteDatabase?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}


class DBFields {
    companion object {
        const val ID: String = "_id" //唯一标志服
        const val DL_URL: String = "DLUrl" //下载的URL
        const val DL_PROGRESS: String = "DLProgress" //下载进度
        const val DL_SIZE: String = "DLSize"  // 下载的文件大小
        const val DL_PATH: String = "DLPath"  //下载路径
        const val DL_STATUS: String = "DLStatus"  //下载状态
    }
}