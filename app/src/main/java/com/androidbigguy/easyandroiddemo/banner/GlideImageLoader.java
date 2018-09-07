package com.androidbigguy.easyandroiddemo.banner;

import android.content.Context;
import android.widget.ImageView;

import com.androidbigguy.easyandroid.banner.loader.ImageLoader;
import com.androidbigguy.easyandroiddemo.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;


public class GlideImageLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
//        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
//        Glide.with(context).load(path).placeholder(R.drawable.nav_header_bg).into(imageView);
        RequestOptions options = new RequestOptions()
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL);
        Glide.with(context).load(path).apply(options).into(imageView);
    }

}
