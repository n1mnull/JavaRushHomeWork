package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

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

    public static String askCurrencyCode() throws IOException
    {
        String test;
        while (true)
        {
            test = readString();
            if (test.length() == 3)
                break;

        }
        test = test.toUpperCase();
        return test;
    }

    public static String[] getValidTwoDigits(String currencyCode) throws IOException
    {
        String[] array;

        while (true)
        {
            String s = readString();
            array = s.split(" ");
            int k;
            int l;
            try {
                k = Integer.parseInt(array[0]);
                l = Integer.parseInt(array[1]);
            }
            catch (Exception ignore) {
            }

            break;
        }
        return array;
    }

    public static Operation askOperation() throws IOException
    {
        while (true)
        {
            try
            {
                String line = readString();
                return Operation.getAllowableOperationByOrdinal(Integer.parseInt(line));
            } catch (IllegalArgumentException ignore) {
                writeMessage(ignore.getMessage());
            }
        }

    }
}
