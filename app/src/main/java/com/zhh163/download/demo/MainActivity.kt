package com.zhh163.download.demo

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.zhh163.component.download.DownloadManager
import java.util.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        const val TAG = "MainActivity"
    }

    private lateinit var startDownload: Button
    private lateinit var pauseDownload: Button
    private lateinit var progress: ProgressBar

    private lateinit var mDownloadManager: DownloadManager;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mDownloadManager = DownloadManager()

        startDownload = findViewById(R.id.button)
        pauseDownload = findViewById(R.id.button2)
        progress = findViewById(R.id.progressBar)

        startDownload.setOnClickListener(this)
        pauseDownload.setOnClickListener(this)

        initPermission();
    }


    //权限申请
    private fun initPermission() {
        val mPermissions = arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_WIFI_STATE)

        val mPermissionList: MutableList<String> = ArrayList()
        for (i in mPermissions.indices) {
            if (ContextCompat.checkSelfPermission(this,
                    mPermissions[i]) != PackageManager.PERMISSION_GRANTED) {
                mPermissionList.add(mPermissions[i])
            }
        }
        if (mPermissionList.isEmpty()) { //未授予的权限为空，表示都授予了
            Log.i(TAG, "权限已经全部授予. first start init media into ....")
        } else { //请求权限方法
            val permissions = mPermissionList.toTypedArray() //将List转为数组
            ActivityCompat.requestPermissions(this, permissions, 0X01)
        }
    }


    override fun onRequestPermissionsResult(requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        Log.i(TAG, "onRequestPermissionResult")
    }


    override fun onClick(v: View?) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        when (v?.id) {
            R.id.button -> {
                Log.i(TAG, "点击了button2")
                Thread() {
                    kotlin.run {
                        mDownloadManager.startDownload("https://www.baidu.com/link?url=uIAEJR-y8Keja1-3V_tlqFn41Ad3loMLj5XeFTqKT9pdA-GEDZPwL10ylJiH8KDX8HY5IUYrJ6qlegeBeS9cNQ0fkCIASCKhwFwFbH7Ogrq&wd=&eqid=d41c859c0007bdae000000065e05cdfb",
                            "mnt/sdcard/MEDIA/download")
                    }
                }.start()

            }
            R.id.button2 -> {
                Log.i(TAG, "点击了button")
            }
            else -> {
                Log.i(TAG, "点击了其他的按钮")
            }

        }
    }
}
