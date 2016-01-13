package com.javarush.test.level07.lesson06.task02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Самая длинная строка
1. Создай список строк.
2. Считай с клавиатуры 5 строк и добавь в список.
3. Используя цикл, найди самую длинную строку в списке.
4. Выведи найденную строку на экран.
5. Если таких строк несколько, выведи каждую с новой строки.
*/
public class Solution
{
    static int maxLength;

    public static void main(String[] args) throws Exception
    {
        ArrayList<String> listString = new ArrayList<String>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i=0;i<5;i++){
            listString.add(reader.readLine());
        }
        for (int i=0;i<5;i++){
            if (listString.get(i).length() > maxLength) {maxLength = listString.get(i).length();}
        }
        for (int i=0;i<5;i++){
            if (listString.get(i).length() == maxLength){
                System.out.println(listString.get(i));
            }
        }

    }
}
