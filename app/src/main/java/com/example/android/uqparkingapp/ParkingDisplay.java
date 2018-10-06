package com.example.android.uqparkingapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.jsoup.select.Elements;

public class ParkingDisplay extends AppCompatActivity {
    public static TextView[][] textViewArray = new TextView[13][3];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking_display);

        for(int i = 1; i<5;i++){
            String carparkID = "P" + i + "CarparkText";
            String permitID = "P" + i + "PermitText";
            String casualID = "P" + i + "CasualText";
            int resCarparkId = getResources().getIdentifier(carparkID,"id",getPackageName());
            int resPermitId = getResources().getIdentifier(permitID,"id",getPackageName());
            int resCasualId = getResources().getIdentifier(casualID,"id",getPackageName());
            textViewArray[i-1][0] = (TextView) findViewById(resCarparkId);
            textViewArray[i-1][1] = (TextView) findViewById(resPermitId);
            textViewArray[i-1][2] = (TextView) findViewById(resCasualId);
        }
        for(int i = 6; i<8;i++){
            String carparkID = "P" + i + "CarparkText";
            String permitID = "P" + i + "PermitText";
            String casualID = "P" + i + "CasualText";
            int resCarparkId = getResources().getIdentifier(carparkID,"id",getPackageName());
            int resPermitId = getResources().getIdentifier(permitID,"id",getPackageName());
            int resCasualId = getResources().getIdentifier(casualID,"id",getPackageName());
            textViewArray[i-2][0] = (TextView) findViewById(resCarparkId);
            textViewArray[i-2][1] = (TextView) findViewById(resPermitId);
            textViewArray[i-2][2] = (TextView) findViewById(resCasualId);
        }
        for(int i=1; i<3;i++){
            String carparkID = "P8L" + i + "CarparkText";
            String permitID = "P8L" + i + "PermitText";
            String casualID = "P8L" + i + "CasualText";
            int resCarparkId = getResources().getIdentifier(carparkID,"id",getPackageName());
            int resPermitId = getResources().getIdentifier(permitID,"id",getPackageName());
            int resCasualId = getResources().getIdentifier(casualID,"id",getPackageName());
            textViewArray[i+5][0] = (TextView) findViewById(resCarparkId);
            textViewArray[i+5][1] = (TextView) findViewById(resPermitId);
            textViewArray[i+5][2] = (TextView) findViewById(resCasualId);
        }
        for(int i=9; i<11;i++){
            String carparkID = "P" + i + "CarparkText";
            String permitID = "P" + i + "PermitText";
            String casualID = "P" + i + "CasualText";
            int resCarparkId = getResources().getIdentifier(carparkID,"id",getPackageName());
            int resPermitId = getResources().getIdentifier(permitID,"id",getPackageName());
            int resCasualId = getResources().getIdentifier(casualID,"id",getPackageName());
            textViewArray[i-1][0] = (TextView) findViewById(resCarparkId);
            textViewArray[i-1][1] = (TextView) findViewById(resPermitId);
            textViewArray[i-1][2] = (TextView) findViewById(resCasualId);
        }
//
        for(int i=1; i<4;i++){
            String carparkID = "P11L" + i + "CarparkText";
            String permitID = "P11L" + i + "PermitText";
            String casualID = "P11L" + i + "CasualText";
            int resCarparkId = getResources().getIdentifier(carparkID,"id",getPackageName());
            int resPermitId = getResources().getIdentifier(permitID,"id",getPackageName());
            int resCasualId = getResources().getIdentifier(casualID,"id",getPackageName());
            textViewArray[i+9][0] = (TextView) findViewById(resCarparkId);
            textViewArray[i+9][1] = (TextView) findViewById(resPermitId);
            textViewArray[i+9][2] = (TextView) findViewById(resCasualId);
        }
    }
    protected void onStart(){
        super.onStart();
        new executeScrapping().execute();
    }

    public void onClickP1(View view) {
        startActivity(new Intent(getApplicationContext(),P1Information.class));
    }

    public void onClickP2(View view) {
        startActivity(new Intent(getApplicationContext(),P2Information.class));
    }

    public void onClickP3(View view) {
        startActivity(new Intent(getApplicationContext(),P3Information.class));
    }

    public void onClickP4(View view) {
        startActivity(new Intent(getApplicationContext(),P4Information.class));
    }

    public void onClickP6(View view) {
        startActivity(new Intent(getApplicationContext(),P6Information.class));
    }

    public void onClickP7(View view) {
        startActivity(new Intent(getApplicationContext(),P7Information.class));
    }

    public void onClickP8L1(View view) {
        startActivity(new Intent(getApplicationContext(),P8L1Information.class));
    }

    public void onClickP8L2(View view) {
        startActivity(new Intent(getApplicationContext(),P8L2Information.class));
    }

    public void onClickP9(View view) {
        startActivity(new Intent(getApplicationContext(),P9Information.class));
    }

    public void onClickP10(View view) {
        startActivity(new Intent(getApplicationContext(),P10Information.class));
    }

    public void onClickP11L1(View view) {
        startActivity(new Intent(getApplicationContext(),P11L1Information.class));
    }

    public void onClickP11L2(View view) {
        startActivity(new Intent(getApplicationContext(),P11L2Information.class));
    }

    public void onClickP11L3(View view) {
        startActivity(new Intent(getApplicationContext(),P11L3Information.class));
    }


    private class executeScrapping extends AsyncTask<Void,Void,Void> {
        String[][] tableElements;
        @Override
        protected Void doInBackground(Void... arg0) {
            String url = "https://www.pf.uq.edu.au/parking/availability/index.html";
            tableElements = HTMLScraping.grabTableElements(url);
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {

            for (int i = 0; i < 13; i++) {
                for(int j = 0; j<3;j++) {
                    textViewArray[i][j].setText(tableElements[i][j]);
                    if(j==1 || j==2){
                        String textViewString = textViewArray[i][j].getText().toString();
                        if(textViewArray[i][j].getText().toString().equals("NEARLY FULL")){
                            textViewArray[i][j].setBackgroundResource(R.color.NearlyFull);
                        }
                        else if(textViewArray[i][j].getText().toString().equals("FULL")){
                            textViewArray[i][j].setBackgroundResource(R.color.Full);
                        }
                        else if(!(textViewString.equals("")) && !(textViewString.equals("NEARLY FULL")) && !(textViewString.equals("FULL"))){
                            textViewArray[i][j].setBackgroundResource(R.color.Space);
                        }
                    }
                }
            }
        }
    }
}
