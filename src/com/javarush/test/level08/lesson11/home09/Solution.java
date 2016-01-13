package com.javarush.test.level08.lesson11.home09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Не забудьте учесть первый день года.
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputString = reader.readLine();
        System.out.println(isDateOdd(inputString));
    }

    public static boolean isDateOdd(String date)
    {
        boolean result = false;
        Date dateInput = new Date(date);
        Date newYear = new Date();
        newYear.setSeconds(0);
        newYear.setMinutes(0);
        newYear.setHours(0);
        newYear.setDate(0);
        newYear.setMonth(0);
        newYear.setYear(dateInput.getYear());
        long msDistance = dateInput.getTime()-newYear.getTime();
        long msDay = 24*60*60*1000;
        int dayCount = (int)(msDistance/msDay);
        if (dayCount % 2 == 0) result = true;

        return result;
    }
}
