package com.example.project;

class CurrencyNotExistsException extends Exception{
    CurrencyNotExistsException(String message) {
        super(message);
    }
}
