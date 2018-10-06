package com.example.android.uqparkingapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static com.example.android.uqparkingapp.ParkingDisplay.textViewArray;

public class P2Information extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p2_information);
        TextView P2ParkingSpace = (TextView) findViewById(R.id.parkingP2Space);
        P2ParkingSpace.setText(textViewArray[1][2].getText().toString());
    }

    public void imageOnClickP2(View view) {
        Uri gmmIntentUri = Uri.parse("geo:0,0?q=-27.49471,153.009112(UQ+P2+Parking)");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }
    }
}
