package com.example.project;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ReturnCurrencyList {
    @RequestMapping("/List")
    @ResponseBody
    public Currencies callme() {
        ArrayList<Currency> curr = new ArrayList<Currency>();
        curr.add(new Currency("DRW", "chuj"));

        Currencies currencies = new Currencies(curr);
//        try {
//            str = CurrencyList.currencyList(GetJSON.getJSON()).toString();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return currencies;

    }
}
