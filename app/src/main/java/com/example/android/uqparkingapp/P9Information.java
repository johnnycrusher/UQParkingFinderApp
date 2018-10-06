package com.example.android.uqparkingapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static com.example.android.uqparkingapp.ParkingDisplay.textViewArray;

public class P9Information extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p9_information);
        TextView P9ParkingSpace = (TextView) findViewById(R.id.parkingP9Space);
        P9ParkingSpace.setText(textViewArray[8][2].getText().toString());
    }

    public void imageOnClickP9(View view) {
        Uri gmmIntentUri = Uri.parse("geo:0,0?q=-27.49234,153.011543(UQ+P9+Parking)");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }
    }
}
