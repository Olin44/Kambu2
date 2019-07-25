package com.example.project;

import java.util.ArrayList;
import java.util.List;

public class Currencies {
    List<Currency>  currencies;

    public Currencies(List<Currency> currencies) {
        this.currencies = currencies;
    }

    public Currencies() {
        currencies = new ArrayList<Currency>();
    }
}
