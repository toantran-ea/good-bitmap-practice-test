package goodbitmap.mobi.toan.nonuibitmap;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
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
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void loadImage(View view) {
        ImageView imageView = (ImageView) findViewById(R.id.sample_image_view);
        BitmapWorkerTask bitmapWorkerTask = new BitmapWorkerTask(imageView);
        bitmapWorkerTask.execute(R.drawable.hd_image);
    }

    public void resetImage(View view) {
        ImageView imageView = (ImageView) findViewById(R.id.sample_image_view);
        imageView.setImageBitmap(null);
    }
}
