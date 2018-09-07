package com.androidbigguy.easyandroid.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;

import com.androidbigguy.easyandroid.R;


/**
 * -----------------------------------------------
 * | 作  者：|@author AndroidBigGuy（QQ295803379）        |
 * -----------------------------------------------
 * | 时  间：| 2018/8/31                             |
 * -----------------------------------------------
 * | 包  名：| mynote.md.com.mynote                     |
 * -----------------------------------------------
 * | 类  名：| NoteEditText                            |
 * -----------------------------------------------
 * | 简  述: | 带下划线的edittext                          |
 * -----------------------------------------------
 */
public class NoteEditText extends AppCompatEditText {
    private Paint linePaint = new Paint();
    private float margin;
    private int paperColor;

    public NoteEditText(Context context) {
        super(context);
    }

    public NoteEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    public NoteEditText(Context paramContext, AttributeSet paramAttributeSet)
    {
        super(paramContext, paramAttributeSet);
        this.linePaint.setColor(getResources().getColor(R.color.noteline));
    }

    protected void setLineColor(Context context,int linecolor){
        this.linePaint.setColor(getResources().getColor(linecolor));
    }
    protected void onDraw(Canvas paramCanvas)
    {
        paramCanvas.drawColor(this.paperColor);
//        获取下化线总数
        int i = getLineCount();
//        获取Edittext发哦度
        int j = getHeight();
//        获取每一行高度
        int k = getLineHeight();

        int m = j / k + 1;
        j = i;
        if (i < m) {
            j = m;
        }
        i = getCompoundPaddingTop();
        float f = (float) Math.ceil(getResources().getDisplayMetrics().density);
        for (m = 0;; m++)
        {
            if (m >= j)
            {
                setPadding((int)this.margin + 10, 0, 0, 0);
                super.onDraw(paramCanvas);
                paramCanvas.restore();
                return;
            }
            i += k;
            paramCanvas.drawLine(0.0F, i + f-30, getRight(), i + f-30, this.linePaint);
            paramCanvas.save();
        }
    }
}
