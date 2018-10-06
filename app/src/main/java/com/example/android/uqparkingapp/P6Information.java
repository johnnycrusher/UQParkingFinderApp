package com.example.android.uqparkingapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static com.example.android.uqparkingapp.ParkingDisplay.textViewArray;

public class P6Information extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p6_information);
        TextView P6ParkingSpace = (TextView) findViewById(R.id.parkingP6Space);
        P6ParkingSpace.setText(textViewArray[4][2].getText().toString());
    }

    public void imageOnClickP6(View view) {
        Uri gmmIntentUri = Uri.parse("geo:0,0?q=-27.495863,153.011664(UQ+P6+Parking)");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }
    }
}
