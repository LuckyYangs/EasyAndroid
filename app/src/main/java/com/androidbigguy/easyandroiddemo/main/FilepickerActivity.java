package com.androidbigguy.easyandroiddemo.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.androidbigguy.easyandroid.matisse.Matisse;
import com.androidbigguy.easyandroid.matisse.MimeType;
import com.androidbigguy.easyandroid.matisse.engine.impl.PicassoEngine;
import com.androidbigguy.easyandroid.matisse.filter.Filter;
import com.androidbigguy.easyandroid.matisse.internal.entity.CaptureStrategy;
import com.androidbigguy.easyandroid.utils.ActivityUtil;
import com.androidbigguy.easyandroid.utils.ToastUtil;
import com.androidbigguy.easyandroiddemo.R;

public class FilepickerActivity extends AppCompatActivity {
Button button;
ListView listView;
    private photoAdapter adapter;
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
                ToastUtil.show(getApplicationContext(),"就知道你要点，滚远点！！");
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_CHOOSE && resultCode == RESULT_OK) {
            adapter=new photoAdapter(FilepickerActivity.this, Matisse.obtainPathResult(data));
            listView.setAdapter(adapter);
//            mAdapter.setData(Matisse.obtainResult(data), Matisse.obtainPathResult(data),SampleActivity.this);
//            Log.e("OnActivityResult ", String.valueOf(Matisse.obtainOriginalState(data)));
        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        ActivityUtil.startAty(this,MainActivity.class);
        finish();
    }
}
