package com.androidbigguy.easyandroid.banner;

import android.support.v4.view.ViewPager.PageTransformer;

import com.androidbigguy.easyandroid.viewpagertransforms.AccordionTransformer;
import com.androidbigguy.easyandroid.viewpagertransforms.BackgroundToForegroundTransformer;
import com.androidbigguy.easyandroid.viewpagertransforms.CubeInTransformer;
import com.androidbigguy.easyandroid.viewpagertransforms.CubeOutTransformer;
import com.androidbigguy.easyandroid.viewpagertransforms.DefaultTransformer;
import com.androidbigguy.easyandroid.viewpagertransforms.DepthPageTransformer;
import com.androidbigguy.easyandroid.viewpagertransforms.DrawerTransformer;
import com.androidbigguy.easyandroid.viewpagertransforms.FlipHorizontalTransformer;
import com.androidbigguy.easyandroid.viewpagertransforms.FlipVerticalTransformer;
import com.androidbigguy.easyandroid.viewpagertransforms.ForegroundToBackgroundTransformer;
import com.androidbigguy.easyandroid.viewpagertransforms.RotateDownTransformer;
import com.androidbigguy.easyandroid.viewpagertransforms.RotateUpTransformer;
import com.androidbigguy.easyandroid.viewpagertransforms.ScaleInOutTransformer;
import com.androidbigguy.easyandroid.viewpagertransforms.StackTransformer;
import com.androidbigguy.easyandroid.viewpagertransforms.TabletTransformer;
import com.androidbigguy.easyandroid.viewpagertransforms.ZoomInTransformer;
import com.androidbigguy.easyandroid.viewpagertransforms.ZoomOutSlideTransformer;
import com.androidbigguy.easyandroid.viewpagertransforms.ZoomOutTranformer;


public class Transformer {
    public static Class<? extends PageTransformer> Default = DefaultTransformer.class;
    public static Class<? extends PageTransformer> Accordion = AccordionTransformer.class;
    public static Class<? extends PageTransformer> BackgroundToForeground = BackgroundToForegroundTransformer.class;
    public static Class<? extends PageTransformer> ForegroundToBackground = ForegroundToBackgroundTransformer.class;
    public static Class<? extends PageTransformer> CubeIn = CubeInTransformer.class;
    public static Class<? extends PageTransformer> CubeOut = CubeOutTransformer.class;
    public static Class<? extends PageTransformer> DepthPage = DepthPageTransformer.class;
    public static Class<? extends PageTransformer> FlipHorizontal = FlipHorizontalTransformer.class;
    public static Class<? extends PageTransformer> FlipVertical = FlipVerticalTransformer.class;
    public static Class<? extends PageTransformer> RotateDown = RotateDownTransformer.class;
    public static Class<? extends PageTransformer> RotateUp = RotateUpTransformer.class;
    public static Class<? extends PageTransformer> ScaleInOut = ScaleInOutTransformer.class;
    public static Class<? extends PageTransformer> Stack = StackTransformer.class;
    public static Class<? extends PageTransformer> Tablet = TabletTransformer.class;
    public static Class<? extends PageTransformer> ZoomIn = ZoomInTransformer.class;
    public static Class<? extends PageTransformer> ZoomOut = ZoomOutTranformer.class;
    public static Class<? extends PageTransformer> ZoomOutSlide = ZoomOutSlideTransformer.class;
    public static Class<? extends PageTransformer> Drawer = DrawerTransformer.class;
}
