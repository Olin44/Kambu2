package com.example.project;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class ControllerCustomCurrencyList {
    @GetMapping("/currencies/list")
    @ResponseBody
    public ResponseEntity customControllerList(@RequestParam("currencies") Collection<String> currencies) {
        String json;
        String date = ActualDate.getDate();
        MongoDB.saveToDb("customControllerList", date);
        try{
            json = CustomCurrencyList.customCurrencyList(currencies);
            return new ResponseEntity<>(json,HttpStatus.OK);}
        catch (Exception e){
            StringBuilder test = new StringBuilder();
            for (String i : currencies){
                test.append(i);
            }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(test + e.toString());
        }

    }
}