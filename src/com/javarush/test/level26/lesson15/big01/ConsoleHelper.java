package com.javarush.test.level26.lesson15.big01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Alenka on 15.04.2016.
 */
public class ConsoleHelper
{
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException
    {
        String message = "";
        try {

             message = bufferedReader.readLine();

        }catch (IOException  ignored) {

        }


        return message;
    }
}
