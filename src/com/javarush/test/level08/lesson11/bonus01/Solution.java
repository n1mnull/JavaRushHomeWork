package com.javarush.test.level08.lesson11.bonus01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* Номер месяца
Программа вводит с клавиатуры имя месяца и выводит его номер на экран в виде: «May is 5 month».
Используйте коллекции.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String monthInput = reader.readLine();

        Map<Integer,String> monthMap = new HashMap<Integer, String>();
        monthMap.put(1, "January");
        monthMap.put(2, "February");
        monthMap.put(3, "March");
        monthMap.put(4, "April");
        monthMap.put(5, "May");
        monthMap.put(6, "June");
        monthMap.put(7, "July");
        monthMap.put(8, "August");
        monthMap.put(9, "September");
        monthMap.put(10, "October");
        monthMap.put(11, "November");
        monthMap.put(12, "December");

        for (Map.Entry<Integer,String> monthFind : monthMap.entrySet())
        {
            if (monthFind.getValue().equals(monthInput))
            {
                System.out.println(monthFind.getValue()+ " is " + monthFind.getKey() +  " month");
            }
        }
    }
}
