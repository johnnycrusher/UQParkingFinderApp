package com.example.android.uqparkingapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static com.example.android.uqparkingapp.ParkingDisplay.textViewArray;

public class P11L1Information extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p11_l1_information);
        TextView P11L1ParkingSpace = (TextView) findViewById(R.id.parkingP11L1Space);
        P11L1ParkingSpace.setText(textViewArray[10][1].getText().toString());
    }

    public void imageOnClickP11L1(View view) {
        Uri gmmIntentUri = Uri.parse("geo:0,0?q=-27.499324,153.018144(UQ+P11L1+Parking)");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }
    }
}
