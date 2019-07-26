package com.example.project;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ControllerCurrencyList {
    @RequestMapping("/currencies")
    @ResponseBody
    public String callme() {
        String str = "";
        try {
            String date = ActualDate.getDate();
            MongoDB.saveToDb("currencies", date);
            str = CurrencyList.currencyList(GetJSON.getJSON()).toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String date = ActualDate.getDate();
        MongoDB.saveToDb("currencies", date);
        return str;

    }
}
