package com.example.android.uqparkingapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static com.example.android.uqparkingapp.ParkingDisplay.textViewArray;

public class P10Information extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p10_information);
        TextView P10ParkingSpace = (TextView) findViewById(R.id.parkingP10Space);
        P10ParkingSpace.setText(textViewArray[9][2].getText().toString());
    }

    public void imageOnClickP10(View view) {
        Uri gmmIntentUri = Uri.parse("geo:0,0?q=-27.496092,153.017328(UQ+P10+Parking)");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }
    }
}
