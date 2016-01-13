package com.javarush.test.level10.lesson11.home05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Количество букв
Ввести с клавиатуры 10 строчек и подсчитать в них количество различных букв (для 33 букв алфавита).  Вывести результат на экран.
Пример вывода:
а 5
б 8
в 3
г 7
…
я 9
*/

public class Solution
{
    public static void main(String[] args)  throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //алфавит
        String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        char[] abcArray = abc.toCharArray();

        ArrayList<Character> alphabet = new ArrayList<Character>();
        for (int i = 0; i < abcArray.length; i++)
        {
            alphabet.add(abcArray[i]);
        }

        //ввод строк
        ArrayList<String> list = new ArrayList<String>();
        /*
        list.add("как сообщает ресурс");
        list.add("полупроводниковой продукции");
        list.add("применением этой технологии");
        list.add("как первоначально планировалось");
        list.add("то же время пробный выпуск");

        list.add("продукции по нормам");
        list.add("высокой производительности");
        list.add("оптимизированного по критерию");
        list.add("намечен на вторую половину этого года");
        list.add("массовое производство");
        */


        for (int i = 0; i < 10; i++)
        {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }


        int[] arrayCounter = new int[abc.length()];

        for (int i=0;i<list.size();i++)
        {
            for (int j=0;j<list.get(i).length();j++)
            {
                if (list.get(i).charAt(j)!=' ')
                {
                    arrayCounter[abc.indexOf(list.get(i).charAt(j))]++;
                }
            }
        }

        for (int i=0;i<abc.length();i++)
        {
            System.out.println(abc.substring(i,i+1)+" "+arrayCounter[i]);
        }
    }

}
