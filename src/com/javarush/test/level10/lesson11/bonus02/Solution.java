package com.javarush.test.level10.lesson11.bonus02;

import org.omg.PortableInterceptor.INACTIVE;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* Нужно добавить в программу новую функциональность
Задача: Программа вводит с клавиатуры пару (число и строку) и выводит их на экран.
Новая задача: Программа вводит с клавиатуры пары (число и строку), сохраняет их в HashMap.
Пустая строка – конец ввода данных. Числа могу повторяться. Строки всегда уникальны. Введенные данные не должны потеряться!
Затем программа выводит содержание HashMap на экран.

Пример ввода:
1
Мама
2
Рама
1
Мыла

Пример вывода:
1 Мама
2 Рама
1 Мыла
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String,Integer> stringHashMap = new HashMap<String, Integer>();


        while (true)
        {
            String tempInt = reader.readLine();
            String name = reader.readLine();
            if (name.isEmpty()||tempInt.isEmpty())
            {
                break;
            }

            int id = Integer.parseInt(tempInt);

            //for (HashMap.Entry<String,Integer> pair : stringHashMap.entrySet())
            if (!stringHashMap.containsKey(name))
            {
                stringHashMap.put(name,id);
            }

        }

        for (String name : stringHashMap.keySet())
            System.out.println(stringHashMap.get(name) + " " + name);


        //System.out.println("Id=" + id + " Name=" + name);
    }
}
