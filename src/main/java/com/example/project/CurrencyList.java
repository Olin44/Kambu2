package com.example.project;

import org.json.JSONArray;
import org.json.JSONTokener;

import java.util.ArrayList;

public class CurrencyList {
    public static JSONArray currencyList(String inline) throws Exception {
        JSONArray json = new JSONArray(new JSONTokener(inline));
        ArrayList currencyList = new ArrayList<String>();
        int currencyListLenght = json.getJSONObject(0).getJSONArray("rates").length();

        //currencyList = getJSONObject(0).getJSONArray("rates");
        return json.getJSONObject(0).getJSONArray("rates");
    }
}