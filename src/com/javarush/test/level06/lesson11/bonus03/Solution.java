package com.javarush.test.level06.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 5 чисел и выводит их в возрастающем порядке.
Пример ввода:
3
2
15
6
17
Пример вывода:
2
3
6
15
17
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        for (int i=0;i<5;i++){
        arrayList.add(Integer.parseInt(reader.readLine()));}

        for (int i=0;i<arrayList.size();i++){
            int min = arrayList.get(i);
            int imin = i;
            for (int j=i;j<arrayList.size();j++){
                if (arrayList.get(j) < min){
                    imin=j;
                    min=arrayList.get(j);
                }
            }
            arrayList.add(i,arrayList.get(imin));
            arrayList.remove(imin+1);
        }
        for (int str : arrayList){
            System.out.println(str);
        }
    }
}
