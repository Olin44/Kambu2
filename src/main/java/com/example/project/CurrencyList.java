package com.example.project;

import org.json.JSONArray;
import org.json.JSONTokener;


class CurrencyList {
    static JSONArray currencyList(String inline) throws Exception {
        JSONArray json = new JSONArray(new JSONTokener(inline));
        return json.getJSONObject(0).getJSONArray("rates");
    }
}