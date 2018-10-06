package com.example.android.uqparkingapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static com.example.android.uqparkingapp.ParkingDisplay.textViewArray;

public class P3Information extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p3_information);
        TextView P3ParkingSpace = (TextView) findViewById(R.id.parkingP3Space);
        P3ParkingSpace.setText(textViewArray[2][1].getText().toString());
    }

    public void imageOnClickP3(View view) {
        Uri gmmIntentUri = Uri.parse("geo:0,0?q=-27.494809,153.009846(UQ+P3+Parking)");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }
    }
}
