package com.javarush.test.level07.lesson12.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 20 чисел и выводит их в убывающем порядке.
*/

public class Solution //не отправлено!!!
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];
        for (int i = 0; i < 20; i++)
        {
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort(array);

        for (int x=array.length-1;x>=0;x--)
        {
            System.out.println(array[x]);
        }
    }

    public static void sort(int[] array)
    {
        for (int i=0;i<array.length;i++){
            int min = array[i];
            int imin = i;
            for (int j=i;j<array.length;j++){
                if (array[j] < min){
                    min=array[j];
                    imin=j;
                }
            }
            int temp = array[i];
            array[i]=min;
            array[imin]=temp;

            //arrayList.add(i,arrayList.get(imin));
           // arrayList.remove(imin+1);
        }

    }
}
