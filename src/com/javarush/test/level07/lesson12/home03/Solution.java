package com.javarush.test.level07.lesson12.home03;

import java.io.*;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.IntSummaryStatistics;
//import java.util.List;

/* Максимальное и минимальное числа в массиве
Создать массив на 20 чисел. Заполнить его числами с клавиатуры. Найти максимальное и минимальное числа в массиве.
Вывести на экран максимальное и минимальное числа через пробел.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] arrayNumbers = new int[20];

        for(int i=0;i<20;i++){
            arrayNumbers[i] = Integer.parseInt((reader.readLine()));}

        int  maximum = arrayNumbers[0];
        int  minimum = arrayNumbers[0];

        for(int i=0;i<20;i++){
            if (maximum<arrayNumbers[i]) {maximum=arrayNumbers[i];}
            if (minimum>arrayNumbers[i]) {minimum=arrayNumbers[i];}
        }
        System.out.println(maximum + " " + minimum);
    }
}
