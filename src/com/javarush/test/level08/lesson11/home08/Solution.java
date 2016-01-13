package com.javarush.test.level08.lesson11.home08;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Пять наибольших чисел
Создать массив на 20 чисел. Заполнить его числами с клавиатуры. Вывести пять наибольших чисел.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++)
        {
            //  array[i] = (int)(Math.random()*20);
            //  System.out.print(array[i] + " ");
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort(array);

        /*for (int i = 0; i < array.length; i++)
        {
            System.out.print(array[i]+" ");
        }*/

        System.out.println(array[0]);
        System.out.println(array[1]);
        System.out.println(array[2]);
        System.out.println(array[3]);
        System.out.println(array[4]);
    }

    public static void sort(int[] array)
    {
        for (int i=0;i<array.length;i++)
        {
            int max=array[i];
            int iMax=i;
            for (int j=i; j<array.length;j++)
            {
                if (max<array[j])
                {
                    max=array[j];
                    iMax=j;
                }
            }
            int tempInt = array[i];
            array[i]=array[iMax];
            array[iMax]=tempInt;
        }
    }
}
