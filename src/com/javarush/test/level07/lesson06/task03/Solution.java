package com.javarush.test.level07.lesson06.task03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Самая короткая строка
1. Создай список строк.
2. Считай с клавиатуры 5 строк и добавь в список.
3. Используя цикл, найди самую короткую строку в списке.
4. Выведи найденную строку на экран.
5. Если таких строк несколько, выведи каждую с новой строки.
*/
public class Solution
{
    static int minLength;

    public static void main(String[] args) throws Exception
    {
        ArrayList<String> listString = new ArrayList<String>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i=0;i<5;i++){
            listString.add(reader.readLine());
        }
        minLength=listString.get(0).length();

        for (int i=1;i<5;i++){
            if (listString.get(i).length() < minLength) {
                minLength = listString.get(i).length();}
        }
        for (int i=0;i<5;i++){
            if (listString.get(i).length() == minLength){
                System.out.println(listString.get(i));
            }
        }

    }
}
