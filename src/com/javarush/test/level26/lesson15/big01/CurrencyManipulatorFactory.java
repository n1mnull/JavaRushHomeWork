package com.javarush.test.level26.lesson15.big01;

import java.util.HashMap;

/**
 * Created by Alenka on 17.04.2016.
 */
public final class CurrencyManipulatorFactory
{

    static HashMap<String, CurrencyManipulator> mapCurrencyManipulator = new HashMap<>();
    static boolean isExist = false;


    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode) {
        isExist = false;
        CurrencyManipulator current;

        if (mapCurrencyManipulator.containsKey(currencyCode))
            return mapCurrencyManipulator.get(currencyCode);
        else {
            current = new CurrencyManipulator(currencyCode);
            mapCurrencyManipulator.put(currencyCode, current);
            return current;
        }
    }

    private CurrencyManipulatorFactory()
    {
    }
}
