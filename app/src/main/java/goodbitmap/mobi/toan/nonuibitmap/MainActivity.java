package goodbitmap.mobi.toan.nonuibitmap;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_load_image:
                loadImage();
                break;
            case R.id.action_reset_image:
                resetImage();
                break;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void loadImage() {
        ImageView imageView = (ImageView) findViewById(R.id.sample_image_view);
        BitmapWorkerTask bitmapWorkerTask = new BitmapWorkerTask(imageView);
        BitmapWorkerTask.Config config = new BitmapWorkerTask.Config();
        int[] reqSizes = getPreferSizes();
        if(reqSizes != null) {
            config.reqHeight = reqSizes[0];
            config.reqWidth = reqSizes[1];
        }
        bitmapWorkerTask.setConfig(config);
        bitmapWorkerTask.execute(R.drawable.hd_image);
    }

    private void resetImage() {
        ImageView imageView = (ImageView) findViewById(R.id.sample_image_view);
        imageView.setImageBitmap(null);
    }

    /**
     * Returns width+height in order as user's preferences.
     */
    private int[] getPreferSizes() {
        int[] reqSizes = new int[2];
        String widthText = ((EditText)findViewById(R.id.reqwidth_input)).getText().toString();
        String heightText = ((EditText)findViewById(R.id.reqheight_input)).getText().toString();
        if(!TextUtils.isEmpty(widthText) && !TextUtils.isEmpty(heightText)) {
            reqSizes[0] = Integer.valueOf(widthText);
            reqSizes[1] = Integer.valueOf(heightText);
        } else {
            reqSizes = null;
        }
        return reqSizes;
    }
}
