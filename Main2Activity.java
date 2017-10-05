package com.example.david.custommenu;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_LONG;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button btn = (Button) findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Usamos alert con su constructor builder
                AlertDialog.Builder alertDConstructor = new AlertDialog.Builder(Main2Activity.this);
                Toast.makeText(Main2Activity.this, "eo", LENGTH_LONG).show();
                alertDConstructor.setTitle("Cerrar app")

                        .setMessage("¿Confirmar salida?")
                        .setCancelable(false)
                        .setPositiveButton("Si", new DialogInterface.OnClickListener(){

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Main2Activity.this.finish();
                            }
                        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog alertD = alertDConstructor.create();
                alertD.show();
            }
        });
    }

}

