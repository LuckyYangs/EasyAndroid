package com.androidbigguy.easyandroid.imagepreview.loader;


import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;

/**

 * Deprecated: 图片加载回调状态接口
 */

public interface MySimpleTarget<T> {
    /**
     * Callback when an image has been successfully loaded.
     * <p>
     * <strong>Note:</strong> You must not recycle the bitmap.
     *
     * @param bitmap 内容
     */
    void onResourceReady(T bitmap);

    void onResourceReady();

    /**
     * Callback indicating the image could not be successfully loaded.
     *
     * @param errorRes 内容
     */
    void onLoadFailed(@Nullable Drawable errorRes);


}
