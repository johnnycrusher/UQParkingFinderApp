package com.example.android.uqparkingapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static com.example.android.uqparkingapp.ParkingDisplay.textViewArray;

public class P4Information extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p4_information);
        TextView P4ParkingSpace = (TextView) findViewById(R.id.parkingP4Space);
        P4ParkingSpace.setText(textViewArray[3][1].getText().toString());
    }

    public void imageOnClickP4(View view) {
        Uri gmmIntentUri = Uri.parse("geo:0,0?q=-27.494891,153.010455(UQ+P4+Parking)");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }
    }
}
