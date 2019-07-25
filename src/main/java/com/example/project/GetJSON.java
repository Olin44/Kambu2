package com.example.project;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class GetJSON {
    public static String getJSON() throws Exception {
        URL url = new URL("http://api.nbp.pl/api/exchangerates/tables/a");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        int responsecode = conn.getResponseCode();
        Scanner sc = new Scanner(url.openStream());
        String inline = "";
        while(sc.hasNext())
        {
            inline += sc.nextLine();
        }
        return inline;
    }
}
