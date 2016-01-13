package com.javarush.test.level07.lesson12.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Нужно добавить в программу новую функциональность
Задача:  Программа вводит строки, пока пользователь не введёт пустую строку (нажав enter). Потом она конвертирует строки в верхний регистр (Мама превращается в МАМА) и выводит их на экран.
Новая задача: Программа вводит строки, пока пользователь не введёт пустую строку (нажав enter).
Потом программа строит новый список. Если в строке чётное число букв, строка удваивается, если нечётное – утраивается.
Программа выводит содержимое нового списка на экран.
Пример ввода:
Кот
Коты
Я
Пример вывода:
Кот Кот Кот
Коты Коты
Я Я Я
*/

public class Solution //не отправлено!!!
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<String>();
        while (true)
        {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        ArrayList<String> listStringOutput = new ArrayList<String>();
        for (int i = 0; i < list.size(); i++)
        {
            if (list.get(i).length()%2 == 0) {
                listStringOutput.add(list.get(i));
                listStringOutput.add(list.get(i));
            }
            if (list.get(i).length()%2 == 1) {
                listStringOutput.add(list.get(i));
                listStringOutput.add(list.get(i));
                listStringOutput.add(list.get(i));
        }

        }

        for (int i = 0; i < listStringOutput.size(); i++)
        {
            System.out.println(listStringOutput.get(i));
        }
    }
}
