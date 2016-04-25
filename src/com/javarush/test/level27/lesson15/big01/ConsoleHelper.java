package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper
{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message)
    {
        System.out.println(message);
    }

    public static String readString() throws IOException
    {
        return br.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException
    {
        List<Dish> dishList = new ArrayList<>();
        writeMessage("Please, choose a dish: " + Dish.allDishesToString());

        do
        {
            String dish = readString();
            if ("exit".equalsIgnoreCase(dish))
            {
                break;
            }
            try
            {
                dishList.add(Dish.valueOf(dish));
            }
            catch (IllegalArgumentException e) {
                ConsoleHelper.writeMessage(String.format("%s is not detected", dish));
            }
        }
        while (true);

        return dishList;

    }


}