package com.gzw.mp.utils;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * coder by 背离记 on 2015/11/4.
 */
public class ImageUtils {

    /**
     * 创建一个400*400的二维码图片
     * @param text 要嵌入二维码的信息
     * @return 返回生成的二维码，注意为空判断
     */
    /*public static Bitmap createQRCode(String text) {
        Bitmap image = null;
        int[] ms;
        int width = 400, height = 400;
        try {
            FileOutputStream out = new FileOutputStream(Environment.getExternalStorageDirectory().getPath() + "/aa/code.png");
            QRCodeWriter writer = new QRCodeWriter();
            String msg = "www.google.com谷歌";
            String msg1 = new String(msg.getBytes(), 0, msg.getBytes().length, "ISO-8859-1");
            BitMatrix matrix = writer.encode(msg1, BarcodeFormat.QR_CODE, width, height);
            ms = new int[width * height];
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    if (matrix.get(x, y)) {
                        ms[y * width + x] = 0xff000000;
                    } else {
                        ms[y * width + x] = 0xffffffff;
                    }
                }
            }
            //内存缓冲区，缓存
            image = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            image.setPixels(ms, 0, width, 0, 0, width, height);
            image.compress(Bitmap.CompressFormat.PNG, 100, out);
            Bitmap bitmap = BitmapFactory.decodeFile(Environment.getExternalStorageDirectory().getPath() + "/aa/aa.png");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return image;
    }*/

    /**
     * 解析二维码
     * @return 解析结果或null
     */
/*
    public static String parseQRCode() {
        Result data = null;
        Bitmap map = BitmapFactory.decodeFile(Environment.getExternalStorageDirectory().getPath() + "/aa/code.png");
        RGBLuminanceSource src = new RGBLuminanceSource(400, 400, ms);
        HybridBinarizer binarizer = new HybridBinarizer(src);
        BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);
        QRCodeReader reader = new QRCodeReader();
        try {
            data = reader.decode(binaryBitmap);
            Log.i("TAG", data.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data.getText();
    }
*/


/*    public static Bitmap QRCodeInitLogo(Bitmap src, Bitmap logo) {
        if (src == null) {
            return null;
        }
        if (logo == null) {
            return src;
        }
        //获取图片的宽高
        int srcWidth = src.getWidth();
        int srcHeight = src.getHeight();
        int logoWidth = logo.getWidth();
        int logoHeight = logo.getHeight();
        if (srcWidth == 0 || srcHeight == 0) {
            return null;
        }
        if (logoWidth == 0 || logoHeight == 0) {
            return src;
        }
        //logo大小为二维码整体大小的1/5
        float scaleFactor = srcWidth * 1.0f / 10 / logoWidth;
        Log.i("TAG", scaleFactor + "");
        Bitmap bitmap = Bitmap.createBitmap(srcWidth, srcHeight, Bitmap.Config.ARGB_8888);
        try {
            Canvas canvas = new Canvas(bitmap);
            canvas.drawBitmap(src, 0, 0, null);
            canvas.scale(scaleFactor, scaleFactor, srcWidth / 2, srcHeight / 2);
            canvas.drawBitmap(logo, (srcWidth - logoWidth) / 2, (srcHeight - logoHeight) / 2, null);
            canvas.save(Canvas.ALL_SAVE_FLAG);
            canvas.restore();
        } catch (Exception e) {
            bitmap = null;
            e.getStackTrace();
        }
        saveImg(bitmap);
        return bitmap;
    }*/

    private static void saveImg(Bitmap bitmap) {
        File file = new File(Environment.getExternalStorageDirectory().getPath() + "/aa/logo.png");
        try {
            file.createNewFile();
            FileOutputStream fout = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fout);
            fout.flush();
            fout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 图片压缩
     * @param bm 要压缩的图片
     * @param newWidth 压缩后宽度
     * @param newHeight 压缩后高度
     * @return 压缩后的图片
     */
    public static Bitmap BitmapCompass(Bitmap bm, int newWidth, int newHeight) {
        // 获得图片的宽高
        int width = bm.getWidth();
        int height = bm.getHeight();
        // 设置想要的大小
        // 计算缩放比例
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;
        // 取得想要缩放的matrix参数
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        // 得到新的图片
        Bitmap newbm = Bitmap.createBitmap(bm, 0, 0, width, height, matrix, true);
        return newbm;
    }

}

