package com.javarush.test.level07.lesson09.task01;


import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Три массива
1. Введи с клавиатуры 20 чисел, сохрани их в список и рассортируй по трём другим спискам:
Число делится на 3 (x%3==0), делится на 2 (x%2==0) и все остальные.
Числа, которые делятся на 3 и на 2 одновременно, например 6, попадают в оба списка.
2. Метод printList должен выводить на экран все элементы списка с новой строки.
3. Используя метод printList выведи эти три списка на экран. Сначала тот, который для x%3, потом тот, который для x%2, потом последний.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        ArrayList<Integer> listInt = new ArrayList<Integer>();
        ArrayList<Integer> listIntDiv2 = new ArrayList<Integer>();
        ArrayList<Integer> listIntDiv3 = new ArrayList<Integer>();
        ArrayList<Integer> listIntOther = new ArrayList<Integer>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i=0;i<20;i++){
            listInt.add(Integer.parseInt(reader.readLine()));}


        for (int i=0;i<20;i++){
            if (listInt.get(i) %3 == 0)
            {
               // System.out.println(listIntDiv3.size());
               // System.out.println(listInt.get(i));
                listIntDiv3.add(listInt.get(i));
            }
            if (listInt.get(i) %2 == 0)
            {
              //  System.out.println(listIntDiv2.size());
              //  System.out.println(listInt.get(i));
                listIntDiv2.add(listInt.get(i));
                // int temp = listInt.get(i);
               // Integer tempi = Integer.valueOf(temp);
               // listIntDiv2.set(tempi);
            }
            if (listInt.get(i) %3 != 0 && listInt.get(i) %2 != 0)
            {
              //  System.out.println(listIntOther.size());
              //  System.out.println(listInt.get(i));
                listIntOther.add(listInt.get(i));
            }
        }
        printList(listIntDiv3);
        printList(listIntDiv2);
        printList(listIntOther);
    }

    public static void printList(List<Integer> list)
    {
        //System.out.println("listSize "+list.size());
        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
}
