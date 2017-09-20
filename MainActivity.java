package es.pixelpro.david.holamundo;

import android.content.Context;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConnectivityManager conex = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        TextView texto = (TextView) findViewById(R.id.textView);

        boolean esWifi = conex.getNetworkInfo(ConnectivityManager.TYPE_WIFI).isConnectedOrConnecting();

        if (!esWifi){
            Log.d("David", "es 3g")
            texto.setText("NOOOOOOOOO");
        }else{
            texto.setText("SIIIIIIIIII");
        }
    }
}
