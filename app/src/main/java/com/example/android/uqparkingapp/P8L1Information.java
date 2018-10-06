package com.example.android.uqparkingapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static com.example.android.uqparkingapp.ParkingDisplay.textViewArray;

public class P8L1Information extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p8_l1_information);
        TextView P8L1ParkingSpace = (TextView) findViewById(R.id.parkingP8L1Space);
        P8L1ParkingSpace.setText(textViewArray[6][2].getText().toString());
    }

    public void imageOnClickP8L1(View view) {
        Uri gmmIntentUri = Uri.parse("geo:0,0?q=-27.493281,153.011590(UQ+P8L1+Parking)");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }
    }
}
