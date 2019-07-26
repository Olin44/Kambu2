package com.example.project;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.Collection;

class CustomCurrencyList {
    static String customCurrencyList(Collection<String> currencies) throws Exception {
        String json = GetJSON.getJSON();
        JSONArray currencyList = CurrencyList.currencyList(json);
        int currencyListLenght = currencyList.length();
        ArrayList<String> response = new ArrayList<>();
        String code;
        String mid;
        for(int i = 0; i < currencyListLenght; i++){
            code = currencyList.getJSONObject(i).getString("code");
            if(currencies.contains(code))
            {
                mid = currencyList.getJSONObject(i).getString("mid");
                response.add(String.format("{ \"%s\": %s}", code, mid));
            }
        }
        return response.toString();
    }
}

