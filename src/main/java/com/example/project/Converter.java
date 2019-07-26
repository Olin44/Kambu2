package com.example.project;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.json.JSONArray;
import org.json.JSONTokener;

class Converter {
    private String Json = "";
    Converter(){
        try {
           Json = GetJSON.getJSON();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private String getresponseJson(){
        return Json;
    }

    private double findCurrency(String currency) throws Exception{
        JSONArray json = new JSONArray(new JSONTokener(getresponseJson()));
        int responseJsonlength = json.getJSONObject(0).getJSONArray("rates").length();
        double findcurrency;
        for(int i = 0; i < responseJsonlength; i++){
            if(currency.equals(json.getJSONObject(0).getJSONArray("rates").getJSONObject(i).getString("code"))){
                findcurrency = json.getJSONObject(0).getJSONArray("rates").getJSONObject(i).getDouble("mid");
                return findcurrency;
            }
        }
        throw new CurrencyNotExistsException("Brak waluty");
    }

    String convert(String from, String to, Double value) throws Exception{
        System.out.println(BigDecimal.valueOf(findCurrency(from)).toString() +" "+ BigDecimal.valueOf(findCurrency(to)).toString() + value);
        BigDecimal response = BigDecimal.valueOf(value).
                multiply(BigDecimal.valueOf(findCurrency(from))).
                divide(BigDecimal.valueOf(findCurrency(to)), 2, RoundingMode.HALF_UP);
        return String.format("{\"%s -> %s\" : %s}", from, to, response.toPlainString());
        }
}

