package com.javarush.test.level14.lesson08.bonus01;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions()
    {
        //it's first exception
        try
        {
            float i = 1 / 0;

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        //2
        try
        {
            float i[] = new float[5];
            i[-1] = 5;

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        //3
        try
        {
            FileReader bufferedReader = new FileReader("");

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        //4
        try
        {
            List list = null;
            list.get(1);

        } catch (Exception e)
        {
            exceptions.add(e);
        }
        //5
        try
        {
            Integer.parseInt("text");

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        //6
        try
        {
            Object x[] = new String[10];
            x[0] = Integer.valueOf(100);

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        //7
        try
        {
            int x[] = new int[-1];

        } catch (Exception e)
        {
            exceptions.add(e);
        }


        //8
        try
        {
            throw new SecurityException();

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        //9
        try
        {
            throw new IllegalStateException();

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        //10
        try
        {
            throw new ClassCastException();

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        //Add your code here

    }
}
