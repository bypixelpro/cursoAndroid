package es.pixelpro.david.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String[] sisOp = {"Linux", "Windows", "Mac"};
    private ListView sisOpListView;
    private ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sisOpListView = (ListView) findViewById(R.id.listView);
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, sisOp);
        sisOpListView.setAdapter(arrayAdapter);

        sisOpListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                int itemPosition = position;
                String itemValue = (String) sisOpListView.getItemAtPosition(position);

                Toast.makeText(MainActivity.this, "Orden: " + itemPosition +    " / S.O: " +  itemValue, Toast.LENGTH_SHORT).show();



            }
        });

    }
}
