package com.javarush.test.level26.lesson15.big01;

import java.util.Locale;

/**
 * Created by Alenka on 15.04.2016.
 */
public class CashMachine
{
    public static void main(String[] args)
    {
        Locale.setDefault(Locale.ENGLISH);

        CurrencyManipulator currencyManipulatorUSD = new CurrencyManipulator("USD");

        currencyManipulatorUSD.addAmount(10,111);
        currencyManipulatorUSD.addAmount(5,33);

        System.out.println(currencyManipulatorUSD.getTotalAmount());

    }
}
