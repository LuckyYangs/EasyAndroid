package com.androidbigguy.easyandroiddemo.resfresh;


import android.content.Context;
import com.androidbigguy.easyandroid.baseadapter.BaseQuickAdapter;
import com.androidbigguy.easyandroid.baseadapter.BaseViewHolder;
import com.androidbigguy.easyandroiddemo.R;

import java.util.List;

/**

 /~~~~~\        /~~~~~\
 |    (~'        ~~~)   |
 \    \__________/    /
 /~::::::::         ~\
 /~~~~~~~-_| ::::::::             |_-~~~~~~~\
 \ ======= /|  ::A::;      A     :|\ ====== /
 ~-_____-~ |  _----------------_::| ~-____-~
 |/~                  ~\|
 /                      \
 (        ()    ()        )
 `\                   ./'
 ~-_______________-~
 /~~~~\
 |      |
 |      |
 (________)
 ()
 *  -----------------------------------------------
 * | 作  者：| AndroidBigGuy（QQ295803379）        
 *  -----------------------------------------------
 * | 时  间：| 2018/5/14
 *  -----------------------------------------------
 * | 包  名：| com.ls.kylibary.custview                     
 *  -----------------------------------------------
 * | 类  名：| UtilsBaseAdapter.java                             
 *  -----------------------------------------------
 * | 简  述: | 工具类适配器
 *  -----------------------------------------------
 */


public class BaseresfresAdapter extends BaseQuickAdapter<StringEntity,BaseViewHolder> {

    Context context;
    int layoutResId;
    List<StringEntity>data;



    public BaseresfresAdapter(Context context , int layoutResId, List<StringEntity>data) {
        super(layoutResId,data);
        this.context=context;
        this.layoutResId=layoutResId;
        this.data=data;
    }

    @Override
    protected void convert(BaseViewHolder helper, StringEntity data) {
        int position = helper.getLayoutPosition();
        helper.setText(R.id.tv_name,data.getContent());
//        helper.setText(R.id.tv_name,data);

    }



}
