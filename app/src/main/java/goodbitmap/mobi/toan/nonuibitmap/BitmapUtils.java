package goodbitmap.mobi.toan.nonuibitmap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

/**
 * Created by toantran on 9/21/15.
 */
public class BitmapUtils {
    public static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        final int height = options.outHeight;
        final int width = options.outWidth;
        int intSampleSize = 1;
        if(height > reqHeight || width > reqWidth) {
            final int halfHeight = height / 2;
            final int halfWidth = width / 2;
            while((halfHeight / intSampleSize) > reqHeight && (halfWidth / intSampleSize) > reqWidth) {
                intSampleSize *= 2;
            }
        }
        return intSampleSize;
    }

    public static Bitmap decodeBitmapFromResource(Resources resource, int resId, int reqWidth, int reqHeight) {
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(resource, resId, options);
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);
        Log.e("BitmapUtils", "inSampleSize = " + options.inSampleSize);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(resource, resId, options);
    }
}
