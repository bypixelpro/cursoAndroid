package es.pixelpro.david.eltiempo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String apiKey = "fb02192e4dbe42151026b58963ad1887";
        double latitude = 37.8267;
        double longitude = -122.4233;
        String elTiempoUrl = "https://api.darksky.net/forecast/"+apiKey+"/"+latitude+","+longitude;

        OkHttpClient client = new OkHttpClient();
        Request peticion = new Request.Builder().url(elTiempoUrl).build();

        // 1) Necesitamos al objeto call para realizar las peticiones
        Call call = client.newCall(peticion);
        //2) La ejecutamos con un bloque try *** Response respouesta = call.execute(); ***

        try {
            Response respuesta = call.execute();
            // Nos mostramos el resultado si es que existe
            if (respuesta.isSuccessful()){
                Log.v(TAG, respuesta.body().string());
            }

        } catch (IOException e) {
            //3) Sacamos un mensaje en el log con la excepcion ocurrida
            Log.e(TAG, "Ha ocurrido un error: ", e);
        }
    }
}
