import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.button);
        Button btn2 = (Button) findViewById(R.id.button2);
        btn.setOnClickListener(this);
        btn2.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        TextView txt = (TextView) findViewById(R.id.txt);

        switch (view.getId()){
            case R.id.button:
                txt.setText("Has pulsado el btn 1");
                break;
            case R.id.button2:
                txt.setText("has pulsado el btn 2");
                break;
        }
        
    }
}
