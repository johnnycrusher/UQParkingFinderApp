package com.example.android.uqparkingapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static com.example.android.uqparkingapp.ParkingDisplay.textViewArray;

public class P7Information extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p7_information);
        TextView P7ParkingSpace = (TextView) findViewById(R.id.parkingP7Space);
        P7ParkingSpace.setText(textViewArray[5][2].getText().toString());
    }

    public void imageOnClickP7(View view) {
        Uri gmmIntentUri = Uri.parse("geo:0,0?q=-27.494059,153.010019(UQ+P7+Parking)");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }
    }
}
