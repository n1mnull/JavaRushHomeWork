package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alenka on 22.04.2016.
 */
public class ConsoleHelper
{
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));


    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {
        String string = bufferedReader.readLine();

        return string;
    }

    public static List<Dish> getAllDishesForOrder() throws IOException
    {
        writeMessage("Выберите доступное блюдо или exit для выхода");
        writeMessage(Dish.allDishesToString());
        String input;
        List<Dish> dishOrder = new ArrayList<>();
        while (!(input = readString()).equalsIgnoreCase("exit")) {
            String temp = null;
            try {
                temp = input.toLowerCase();
                dishOrder.add(Dish.valueOf(input));
            } catch (IllegalArgumentException e) {
                writeMessage(temp +" is not detected");
            }
        }
        return dishOrder;
    }
}
