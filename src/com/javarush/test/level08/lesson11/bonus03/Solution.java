package com.javarush.test.level08.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Задача по алгоритмам
Задача: Введи с клавиатуры 20 слов и выведи их в алфавитном порядке.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] array = new String[20]; //{"Москва","Ивановы","Киев","Петровы","Лондон","Абрамовичи","Лондона","Абрамовича","Абромович"};
        for (int i = 0; i < array.length; i++)
        {
            array[i] = reader.readLine();
        }

        sort(array);

        for (String x : array)
        {
            System.out.println(x);
        }
    }

    public static void sort(String[] array)
    {
        /*for (int i=0;i<array.length;i++)
        {
            String maxStr = array[i];
            int iMax = i;
            for (int j=i;j<array.length;j++)
            {
                if (isGreaterThan(array[j],maxStr))
                {
                    iMax = j;
                    maxStr = array[j];
                }
            }
            array[iMax] = array[i];
            array[i] = maxStr;
        }*/
        for (int i=0;i<array.length;i++)
        {
            String minStr = array[i];
            int iMin = i;
            for (int j=i;j<array.length;j++)
            {
                if (!isGreaterThan(array[j],minStr))
                {
                    iMin = j;
                    minStr = array[j];
                }
            }
            array[iMin] = array[i];
            array[i] = minStr;
        }
    }

    public static boolean isGreaterThan(String a, String b)
    {
        return a.compareTo(b) > 0;
    }
}
