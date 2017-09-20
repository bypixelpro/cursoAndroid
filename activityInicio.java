package es.pixelpro.david.holamundo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static es.pixelpro.david.holamundo.R.id.button;

public class activityInicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        Button irActDestino = (Button) findViewById(R.id.button);
        irActDestino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(activityInicio.this, destinoActivity.class));
            }
        });
    }
}
