package es.pixelpro.david.eltiempo;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    //8 Cargamos el tiempo
    private CurrentWeather mCurrentWeather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String apiKey = "fb02192e4dbe42151026b58963ad1887";
        double latitude = 37.8267;
        double longitude = -122.4233;
        String elTiempoUrl = "https://api.darksky.net/forecast/"+apiKey+"/"+latitude+","+longitude;

        //7) Checkeamos la red antes de empezar
        if (tenemosRed()) {
            OkHttpClient client = new OkHttpClient();
            Request peticion = new Request.Builder().url(elTiempoUrl).build();

            // 1) Necesitamos al objeto call para realizar las peticiones
            Call call = client.newCall(peticion);
            //2) La ejecutamos con un bloque try *** Response respouesta = call.execute(); ***

            //5) Metodo asincrono, callback
            call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {


                    try {
                        //9)
                        String jsonData = response.body().string();
                        Log.v(TAG, jsonData);
                        if (response.isSuccessful()) {
                            mCurrentWeather = getCurrentDetails(jsonData);

                        } else {
                            alertUserAboutError();
                        }

                    } catch (IOException e) {
                        //3) Sacamos un mensaje en el log con la excepcion ocurrida
                        Log.e(TAG, "Ha ocurrido un error: ", e);
                    }
                    catch (JSONException e){
                        Log.e(TAG, "Ha ocurrido un error: ", e);

                    }

                }
            });
        }else {
            Toast.makeText(this, "No hay conexión a internet", Toast.LENGTH_SHORT ).show();
        }
        Log.v(TAG, "Ejecutamos el hilo principal");

    }

    private CurrentWeather getCurrentDetails(String jsonData) throws JSONException {

        JSONObject forecast = new JSONObject(jsonData);
        String timezone = forecast.getString("timezone");


        return new CurrentWeather();
    }

    private boolean tenemosRed() {
        ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkinfo = manager.getActiveNetworkInfo();

        //8 si hay y esta conectado, devolvemos true
        boolean hayRed = false;
        if (networkinfo != null && networkinfo.isConnected()){
            hayRed = true;
        }
        return hayRed;
    }

    private void alertUserAboutError() {
        AlertaUsuarioFragment dialog = new AlertaUsuarioFragment();
        dialog.show(getFragmentManager(), "error");
    }
}
