package com.example.android.uqparkingapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static com.example.android.uqparkingapp.ParkingDisplay.textViewArray;

public class P11L2Information extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p11_l2_information);
        TextView P11L2ParkingSpace = (TextView) findViewById(R.id.parkingP11L2Space);
        P11L2ParkingSpace.setText(textViewArray[11][1].getText().toString());
    }

    public void imageOnClickP11L2(View view) {
        Uri gmmIntentUri = Uri.parse("geo:0,0?q=-27.499324,153.018144(UQ+P11L2+Parking)");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }
    }

}
