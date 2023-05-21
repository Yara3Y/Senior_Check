package com.example.sp_check1;

import android.annotation.SuppressLint;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.transition.Explode;
import android.view.Window;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;


import com.example.sp_check1.databinding.ActivityMapsSpBinding;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class Maps_SP extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    private ActivityMapsSpBinding binding;

    private LatLng  gate2 = new LatLng(21.579553, 39.180162);
    private LatLng  gate3 = new LatLng(21.578229, 39.180501);

    private Marker Mgate2;
    private Marker Mgate3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsSpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

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
        mMap = googleMap;
        mMap.setMapType(googleMap.MAP_TYPE_HYBRID);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setAllGesturesEnabled(true);
        mMap.getUiSettings().setCompassEnabled(true);

        List<Marker> markerList = new ArrayList<>();

        Mgate2 = mMap.addMarker(new MarkerOptions().position(gate2).title("gate 2"));
        Mgate2.setTag(0);
        markerList.add(Mgate2);

        Mgate3 = mMap.addMarker(new MarkerOptions().position(gate3).title("gate 3"));
        Mgate3.setTag(0);
        markerList.add(Mgate3);



        mMap.setOnMarkerClickListener(this::onMarkerClick);



        for(Marker m : markerList){
            LatLng latLng = new LatLng(m.getPosition().latitude,m.getPosition().longitude);
            mMap.addMarker(new MarkerOptions().position(latLng));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,17));
//           CameraUpdate cameraUpdate= CameraUpdateFactory.newLatLngZoom(latLng,16);
//            mMap.animateCamera(cameraUpdate);
        }
    }

    @SuppressLint("NewApi")
    public boolean onMarkerClick(@NonNull Marker marker) {

        String tit = marker.getTitle();

        if (tit.equals("gate 2")){

            Intent intent = new Intent(this,ParkingLots.class);
            startActivity(intent);
            overridePendingTransition(R.drawable.anim,R.drawable.anim);

        }
        if (tit.equals("gate 3")){
            Toast.makeText(Maps_SP.this,
                    " net yet ",Toast.LENGTH_SHORT).show();;

        }


        return false;
    }
}
