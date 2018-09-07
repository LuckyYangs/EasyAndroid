package com.androidbigguy.easyandroid.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * /~~~~~\        /~~~~~\
 * |    (~'        ~~~)   |
 * \    \__________/    /
 * /~::::::::         ~\
 * /~~~~~~~-_| ::::::::             |_-~~~~~~~\
 * \ ======= /|  ::A::;      A     :|\ ====== /
 * ~-_____-~ |  _----------------_::| ~-____-~
 * |/~                  ~\|
 * /                      \
 * (        ()    ()        )
 * `\                   ./'
 * ~-_______________-~
 * /~~~~\
 * |      |
 * |      |
 * (________)
 * ()
 * -----------------------------------------------
 * | 作  者：| AndroidBigGuy（QQ295803379）        |
 * -----------------------------------------------
 * | 时  间：| 2018/9/1                             |
 * -----------------------------------------------
 * | 包  名：| mynote.md.com.jinli                     |
 * -----------------------------------------------
 * | 类  名：| $class$                             |
 * -----------------------------------------------
 * | 简  述: | <功能简述>                          |
 * -----------------------------------------------
 */
public class EditScrollView extends ScrollView {
    public EditScrollView(Context paramContext)
    {
        super(paramContext);
    }

    public EditScrollView(Context paramContext, AttributeSet paramAttributeSet)
    {
        super(paramContext, paramAttributeSet);
    }

    public EditScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
        super(paramContext, paramAttributeSet, paramInt);
    }

    protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect)
    {
        return true;
    }
}
