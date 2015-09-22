package goodbitmap.mobi.toan.nonuibitmap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.lang.ref.WeakReference;

/**
 * Created by toantran on 9/22/15.
 */
public class BitmapWorkerTask extends AsyncTask<Integer, Void, Bitmap> {
    private WeakReference<ImageView> mImageViewReference;
    private int data;
    private WeakReference<Resources> mResourcesReference;
    private Config mConfig = new Config();

    public BitmapWorkerTask(ImageView imageView) {
        mImageViewReference = new WeakReference<>(imageView);
        mResourcesReference = new WeakReference<>(imageView.getResources());
    }

    public void setConfig(Config config) {
        this.mConfig = config;
    }

    @Override
    protected Bitmap doInBackground(Integer... params) {
        data = params[0];
        return BitmapUtils.decodeBitmapFromResource(mResourcesReference.get(), data, mConfig.reqWidth, mConfig.reqHeight);
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        if (mImageViewReference != null && bitmap != null) {
            mImageViewReference.get().setImageBitmap(bitmap);
        }
    }

    public static class Config {
        public int reqHeight = 300;
        public int reqWidth = 300;
    }
}
