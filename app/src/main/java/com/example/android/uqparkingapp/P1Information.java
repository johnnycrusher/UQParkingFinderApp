package com.example.android.uqparkingapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static com.example.android.uqparkingapp.ParkingDisplay.textViewArray;

public class P1Information extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p1_information);
    }
    protected void onStart(){
        super.onStart();
        TextView P1ParkingSpace = (TextView) findViewById(R.id.parkingP1Space);
        P1ParkingSpace.setText(textViewArray[0][2].getText().toString());
    }

    public void imageOnClickP1(View view) {
        Uri gmmIntentUri = Uri.parse("geo:0,0?q=-27.4945,153.0087(UQ+P1+Parking)");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }
    }
}
