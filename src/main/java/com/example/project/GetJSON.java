package com.example.project;

import org.json.JSONArray;
import org.json.JSONTokener;

import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

class GetJSON {
    static String getJSON() throws Exception {
        StringBuilder json = new StringBuilder();
        URL url = new URL("http://api.nbp.pl/api/exchangerates/tables/a");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        Scanner sc = new Scanner(url.openStream());
        while (sc.hasNext()) {
            json.append(sc.nextLine());
        }
        String date = ActualDate.getDate();
        MongoDB.saveToDb("NBP API Connection", date);
        return json.toString();
    }
}
