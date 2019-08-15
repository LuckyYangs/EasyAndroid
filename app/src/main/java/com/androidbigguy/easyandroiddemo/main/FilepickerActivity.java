package com.androidbigguy.easyandroiddemo.main;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.androidbigguy.easyandroid.luban.CompressionPredicate;
import com.androidbigguy.easyandroid.luban.Luban;
import com.androidbigguy.easyandroid.luban.OnCompressListener;
import com.androidbigguy.easyandroid.luban.OnRenameListener;
import com.androidbigguy.easyandroid.matisse.Matisse;
import com.androidbigguy.easyandroid.matisse.MimeType;
import com.androidbigguy.easyandroid.matisse.engine.impl.PicassoEngine;
import com.androidbigguy.easyandroid.matisse.filter.Filter;
import com.androidbigguy.easyandroid.matisse.internal.entity.CaptureStrategy;
import com.androidbigguy.easyandroid.utils.ActivityUtil;
import com.androidbigguy.easyandroid.utils.ToastUtil;
import com.androidbigguy.easyandroiddemo.R;

import java.io.File;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class FilepickerActivity extends AppCompatActivity {
Button button;
ListView listView;
    private photoAdapter adapter;
    List<String> datalist=new ArrayList<>();
    private static final int REQUEST_CODE_CHOOSE = 88;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filepicker);
        button=findViewById(R.id.bt_select);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Matisse.from(FilepickerActivity.this)
                        .choose(MimeType.ofAll(), false)
                        .countable(true)
                        .capture(true)
                        .captureStrategy(new CaptureStrategy(true, "com.androidbigguy.easyandroiddemo.fileprovider"))
                        .theme(R.style.Matisse_Zhihu)
                        .maxSelectable(9)
                        .originalEnable(true)
                        .maxOriginalSize(10)
                        .imageEngine(new Glide4Engine())
                        .forResult(REQUEST_CODE_CHOOSE);
            }
        });
        listView =  findViewById(R.id.lv_picker);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                File file =new File(datalist.get(position));

                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                options.inSampleSize = 1;

                BitmapFactory.decodeFile(file.getAbsolutePath(), options);

                ToastUtil.show(getApplicationContext(),"图片大小："+options.outWidth+"*"+options.outHeight+":"+file.length()/1024+"kb");

            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_CHOOSE && resultCode == RESULT_OK) {
//图片压缩
            Luban.with(this)
                    .load(Matisse.obtainPathResult(data))
                    .ignoreBy(100)
                    .setTargetDir(getPath())
                    .setFocusAlpha(false)
                    .filter(new CompressionPredicate() {//设置压缩限制，gif无法压缩，压缩之后是png格式。
                        @Override
                        public boolean apply(String path) {
                            return !(TextUtils.isEmpty(path) || path.toLowerCase().endsWith(".gif"));
                        }
                    })
                    .setRenameListener(new OnRenameListener() {//MD5重命名
                        @Override
                        public String rename(String filePath) {
                            try {
                                MessageDigest md = MessageDigest.getInstance("MD5");
                                md.update(filePath.getBytes());
                                return new BigInteger(1, md.digest()).toString(32);
                            } catch (NoSuchAlgorithmException e) {
                                e.printStackTrace();
                            }
                            return "";
                        }
                    })
                    .setCompressListener(new OnCompressListener() {
                        @Override
                        public void onStart() { }

                        @Override
                        public void onSuccess(File file) {
                            Log.i("file", file.length()+"");
                             datalist.add(file.getAbsolutePath());
                            adapter=new photoAdapter(FilepickerActivity.this, datalist);
                            listView.setAdapter(adapter);
                        }

                        @Override
                        public void onError(Throwable e) { }
                    }).launch();
        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        ActivityUtil.startAty(this,MainActivity.class);
        finish();
    }
    private String getPath() {
        String path = Environment.getExternalStorageDirectory() + "/XXXXX/image/";
        File file = new File(path);
        if (file.mkdirs()) {
            return path;
        }
        return path;
    }
}
