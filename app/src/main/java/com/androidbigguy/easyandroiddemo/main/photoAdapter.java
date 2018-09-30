package com.androidbigguy.easyandroiddemo.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.androidbigguy.easyandroiddemo.R;
import com.bumptech.glide.Glide;

import java.util.List;


/**
 * 作  者：李洋 （liyangman518@163.com）
 * 时  间：2017/5/22 15:29
 * 项目名：wwx
 * 包  名：com.md.wwx.adapter
 * 类  名：AllShopAdapter
 * 描  述: 商家秀适配器
 */
public class photoAdapter extends BaseAdapter {
    private Context context;
    private List<String> Datalist ;
    private LayoutInflater inflater;
    public photoAdapter(Context context, List<String> datalist) {
        super();
        this.context = context;
        this.Datalist = datalist;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {

        return Datalist.size();
    }

    @Override
    public Object getItem(int position) {

        return Datalist.get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final String data=Datalist.get(position);

        ViewHolder holder =null;

        if(holder==null){
        holder = new ViewHolder();
        }
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.uri_item, null);
            holder.iv_item_spshow=  convertView.findViewById(R.id.tt);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Glide.with(context).load(data).into(holder.iv_item_spshow);

        return convertView;
    }
    public class ViewHolder{
        ImageView iv_item_spshow;
    }
}
