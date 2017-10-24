package es.pixelpro.david.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private Intent emailIntent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



// Creamos un Intent con Action Send, esta acción esta vinculada al envio de correos y compartir archivos
                emailIntent = new Intent(android.content.Intent.ACTION_SEND);
                emailIntent.setType("plain/text");

// Put extra lo usamos para pasar información entre activities incluso aplicaciones
                emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"info@pixelpro.es"});
                emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Contacto desde Pixelpro Apps");


// Iniciamos el intent con las apps del usuario

                startActivity(Intent.createChooser(emailIntent, "Elige una app para enviar el correo"));

                Snackbar.make(view, "Enviando correo...", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
