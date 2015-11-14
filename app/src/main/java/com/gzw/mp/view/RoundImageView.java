package com.gzw.mp.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.gzw.mp.R;

/**
 *
 * @author Grrsun
 * 自定义圆形ImageView
 *
 */
public class RoundImageView extends ImageView {

    //圆形边框厚度
    private int mBorderThickness = 0;
    //上下文对象
    private Context mContext;
    //默认ImageView背景颜色
    private int defaultColor = 0XFFFFFFFF;
    //内外边框的颜色 如果只有其中一个有值 则只画一个边框
    private int mBorderOutsideColor = 0;
    private int mBorderInsideColor = 0;
    //控件默认长宽
    private int defaultWidth = 0;
    private int defaultHeight = 0;

    /**
     * 构造方法1 2 3
     *
     * @param context
     */
    public RoundImageView(Context context) {
        super(context);
        mContext = context;
    }

    public RoundImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        setCustomAttributes(attrs);
    }

    public RoundImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        setCustomAttributes(attrs);
    }

    private void setCustomAttributes(AttributeSet attrs) {
        TypedArray a = mContext.obtainStyledAttributes(attrs, R.styleable.roundedimageview);
        mBorderThickness = a.getDimensionPixelSize(R.styleable.roundedimageview_border_thickness, 0);
        mBorderOutsideColor = a.getDimensionPixelSize(R.styleable.roundedimageview_border_outside_color, defaultColor);
        mBorderInsideColor = a.getDimensionPixelSize(R.styleable.roundedimageview_border_inside_color, defaultColor);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        if (getWidth() == 0 || getHeight() == 0) {
            return;
        }
        this.measure(0, 0);
        if (drawable.getClass() == NinePatchDrawable.class)
            return;
        ;
        Bitmap b = ((BitmapDrawable) drawable).getBitmap();
        Bitmap bitmap = b.copy(Config.ARGB_8888, true);
        if (defaultWidth == 0) {
            defaultWidth = getWidth();
        }
        if (defaultHeight == 0) {
            defaultHeight = getHeight();
        }
        //半径
        int radius = 0;
        if (mBorderInsideColor != defaultColor && mBorderOutsideColor != defaultColor) {
            //画两个边框 外圆边框和内圆边框
            radius = (defaultWidth < defaultHeight ? defaultWidth : defaultHeight) / 2 - 2 * mBorderThickness;
            //画内圆
            drawCircleBorder(canvas, radius + mBorderThickness / 2, mBorderInsideColor);
            //画外圆
            drawCircleBorder(canvas, radius + mBorderThickness + mBorderThickness / 2, mBorderOutsideColor);
        } else if (mBorderInsideColor != defaultColor && mBorderOutsideColor == defaultColor) {
            //画一个边框
            radius = (defaultWidth < defaultHeight ? defaultWidth : defaultHeight) / 2 - mBorderThickness;
            drawCircleBorder(canvas, radius + mBorderThickness / 2, mBorderInsideColor);
        } else if (mBorderInsideColor == defaultColor && mBorderOutsideColor != defaultColor) {
            //画一个边框
            radius = (defaultWidth < defaultHeight ? defaultWidth : defaultHeight) / 2 - mBorderThickness;
            drawCircleBorder(canvas, radius + mBorderThickness + mBorderThickness / 2, mBorderOutsideColor);
        } else {
            //无边框(To 贾跃亭:这是真正的无边框,不是ID无边框,我们无法提供F1赛场)
            radius = (defaultWidth < defaultHeight ? defaultWidth : defaultHeight) / 2;
        }
        Bitmap roundBitmap = getCroppedRoundBitmap(bitmap, radius);
        canvas.drawBitmap(roundBitmap, defaultWidth / 2 - radius, defaultHeight / 2 - radius, null);
    }

    /**
     * 获取剪裁后的圆形图片
     */
    public Bitmap getCroppedRoundBitmap(Bitmap bmp, int radius) {
        Bitmap scaledSrcBmp;
        int diameter = radius * 2;
        // 为了防止宽高不相等，造成圆形图片变形，因此截取长方形中处于中间位置最大的正方形图片
        int bmpWidth = bmp.getWidth();
        int bmpHeight = bmp.getHeight();
        int squareWidth = 0, squareHeight = 0;
        int x = 0, y = 0;
        Bitmap squareBitmap;
        if (bmpHeight > bmpWidth) {// 高大于宽
            squareWidth = squareHeight = bmpWidth;
            x = 0;
            y = (bmpHeight - bmpWidth) / 2;
            // 截取正方形图片
            squareBitmap = Bitmap.createBitmap(bmp, x, y, squareWidth, squareHeight);
        } else if (bmpHeight < bmpWidth) {// 宽大于高
            squareWidth = squareHeight = bmpHeight;
            x = (bmpWidth - bmpHeight) / 2;
            y = 0;
            squareBitmap = Bitmap.createBitmap(bmp, x, y, squareWidth, squareHeight);
        } else {
            squareBitmap = bmp;
        }
        if (squareBitmap.getWidth() != diameter || squareBitmap.getHeight() != diameter) {
            scaledSrcBmp = Bitmap.createScaledBitmap(squareBitmap, diameter, diameter, true);
        } else {
            scaledSrcBmp = squareBitmap;
        }
        Bitmap output = Bitmap.createBitmap(scaledSrcBmp.getWidth(),
                scaledSrcBmp.getHeight(),
                Config.ARGB_8888);
        Canvas canvas = new Canvas(output);

        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, scaledSrcBmp.getWidth(), scaledSrcBmp.getHeight());

        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setDither(true);
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawCircle(scaledSrcBmp.getWidth() / 2,
                scaledSrcBmp.getHeight() / 2,
                scaledSrcBmp.getWidth() / 2,
                paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(scaledSrcBmp, rect, rect, paint);
        bmp = null;
        squareBitmap = null;
        scaledSrcBmp = null;
        return output;
    }

    /**
     * 画圆的边框
     */
    private void drawCircleBorder(Canvas canvas, int radius, int color) {
        Paint paint = new Paint();
        //消除锯齿
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setDither(true);
        //画笔颜色
        paint.setColor(color);
        //设置paint的style为STROKE 空心
        paint.setStyle(Paint.Style.STROKE);
        //paint的外边框宽度
        paint.setStrokeWidth(mBorderThickness);
        //开始画圆
        canvas.drawCircle(defaultWidth / 2, defaultHeight / 2, radius, paint);
    }
}

