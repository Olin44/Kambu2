package com.example.project;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ControllerConverter {
    @GetMapping("/currencies/convert")
    @ResponseBody
    public ResponseEntity converter(@RequestParam String from, @RequestParam String to, @RequestParam Double value) {
        String json;
        try{
            json = new Converter().convert(from, to, value);
            String date = ActualDate.getDate();
            MongoDB.saveToDb("converter", date);
            return new ResponseEntity<>(json,HttpStatus.OK);}
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.toString());
        }

    }
}