package es.pixelpro.david.captureimage;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class destinoImage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destino_image);

        ImageView img = (ImageView) findViewById(R.id.imageView2);
        img.setImageURI((Uri) getIntent().getExtras().get(Intent.EXTRA_STREAM));
    }
}
