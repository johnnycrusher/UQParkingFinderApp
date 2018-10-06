package com.example.android.uqparkingapp;
import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
/**
 * Created by John_ on 15/02/2018.
 */

public class HTMLScraping {
    private static Document doc;

    public static void ConnectToWebpage(String url) {
        try {
            doc = Jsoup.connect(url).get();
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static String[][] grabTableElements(String url) {

        ConnectToWebpage(url);
        Elements iframe = doc.select("#parkingAvailbilityEmbedded");
        String newurl = iframe.attr("src");
        ConnectToWebpage(newurl);
        Elements table = doc.select("#parkingAvailability");
        Elements tableRows = table.select("tr");
        Element row;
        Elements cols;
        String[][] extractedElement = new String[13][3];
        ArrayList<Elements> IndivCols = new ArrayList<>();
        for (int i=1; i<tableRows.size();i++) {
            row = tableRows.get(i);
            cols = row.select("td");
            IndivCols.add(cols);
        }
        for (int i =0; i<13;i++) {
            for(int j = 0;j<3;j++) {
                extractedElement[i][j] = IndivCols.get(i).get(j).text();
            }
        }
        return extractedElement;
    }
}
