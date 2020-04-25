package com.androidbigguy.easyandroiddemo.main

import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Environment
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.ListView

import com.androidbigguy.easyandroid.luban.CompressionPredicate
import com.androidbigguy.easyandroid.luban.Luban
import com.androidbigguy.easyandroid.luban.OnCompressListener
import com.androidbigguy.easyandroid.luban.OnRenameListener
import com.androidbigguy.easyandroid.matisse.Matisse
import com.androidbigguy.easyandroid.matisse.MimeType
import com.androidbigguy.easyandroid.matisse.internal.entity.CaptureStrategy
import com.androidbigguy.easyandroid.utils.ActivityUtil
import com.androidbigguy.easyandroid.utils.ToastUtil
import com.androidbigguy.easyandroiddemo.R

import java.io.File
import java.math.BigInteger
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.util.ArrayList

class sss : AppCompatActivity() {
    internal var button: Button
    internal var listView: ListView
    private var adapter: photoAdapter? = null
    internal var datalist: MutableList<String> = ArrayList()
    private val path: String
        get() {
            val path = Environment.getExternalStorageDirectory().toString() + "/XXXXX/image/"
            val file = File(path)
            return if (file.mkdirs()) {
                path
            } else path
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filepicker)
        button = findViewById(R.id.bt_select)
        button.setOnClickListener {
            Matisse.from(this@sss)
                    .choose(MimeType.ofAll(), false)
                    .countable(true)
                    .capture(true)
                    .captureStrategy(CaptureStrategy(true, "com.androidbigguy.easyandroiddemo.fileprovider"))
                    .theme(R.style.Matisse_Zhihu)
                    .maxSelectable(9)
                    .originalEnable(true)
                    .maxOriginalSize(10)
                    .imageEngine(Glide4Engine())
                    .forResult(REQUEST_CODE_CHOOSE)
        }
        listView = findViewById(R.id.lv_picker)
        listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val file = File(datalist[position])

            val options = BitmapFactory.Options()
            options.inJustDecodeBounds = true
            options.inSampleSize = 1

            BitmapFactory.decodeFile(file.absolutePath, options)

            ToastUtil.show(applicationContext, "图片大小：" + options.outWidth + "*" + options.outHeight + ":" + file.length() / 1024 + "kb")
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_CHOOSE && resultCode == Activity.RESULT_OK) {
            //图片压缩
            Luban.with(this)
                    .load(Matisse.obtainPathResult(data!!))
                    .ignoreBy(100)
                    .setTargetDir(path)
                    .setFocusAlpha(false)
                    .filter { path -> //设置压缩限制，gif无法压缩，压缩之后是png格式。
                        !(TextUtils.isEmpty(path) || path.toLowerCase().endsWith(".gif"))
                    }
                    .setRenameListener(OnRenameListener { filePath ->
                        //MD5重命名
                        try {
                            val md = MessageDigest.getInstance("MD5")
                            md.update(filePath.toByteArray())
                            return@OnRenameListener BigInteger(1, md.digest()).toString(32)
                        } catch (e: NoSuchAlgorithmException) {
                            e.printStackTrace()
                        }

                        ""
                    })
                    .setCompressListener(object : OnCompressListener {
                        override fun onStart() {}

                        override fun onSuccess(file: File) {
                            Log.i("file", file.length().toString() + "")
                            datalist.add(file.absolutePath)
                            adapter = photoAdapter(this@sss, datalist)
                            listView.adapter = adapter
                        }

                        override fun onError(e: Throwable) {}
                    }).launch()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        ActivityUtil.startAty(this, MainActivity::class.java)
        finish()
    }

    companion object {
        private val REQUEST_CODE_CHOOSE = 88
    }
}
