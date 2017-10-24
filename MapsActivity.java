package es.pixelpro.david.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {

        LatLng pixelpro = new LatLng(40.4069888, -3.7133261000000175);
        LatLng colme = new LatLng(40.6626481, -3.771045700000059);
        LatLng madrid = new LatLng(40.4167754, -3.7037901999999576);

        mMap = googleMap;

        mMap.setMinZoomPreference(9.0f);
        //mMap.setMaxZoomPreference(20.0f);
        mMap.addMarker(new MarkerOptions().position(pixelpro).title("Pixelpro Cursos - Ronda Segovia").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_home)));
        mMap.addMarker(new MarkerOptions().position(colme).title("Pixelpro Cursos - Colmenar Viejo").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_home)));

        mMap.moveCamera(CameraUpdateFactory.newLatLng(madrid));
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.setBuildingsEnabled(true);
        mMap.addPolyline(new PolylineOptions()
                .add(new LatLng(40.4069888, -3.7133261000000175), new LatLng(40.6626481, -3.771045700000059))
                .width(5)
                .color(Color.RED));

    }


}
