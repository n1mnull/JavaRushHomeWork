package com.javarush.test.level08.lesson11.home05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Мама Мыла Раму. Теперь с большой буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа заменяет в тексте первые буквы всех слов на заглавные.
Вывести результат на экран.

Пример ввода:
  мама     мыла раму.

Пример вывода:
  Мама     Мыла Раму.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        String stringResult="";
        String tempStr;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String stringInput = reader.readLine();
        //String stringInput = "мама     мыла раму.";
        char[] charStr = stringInput.toCharArray();

        for (int i=0;i<charStr.length;i++)
        {
            tempStr = ""+charStr[i];
            if (i==0){
                stringResult=stringResult+tempStr.toUpperCase();
            }
            if (i!=0 && charStr[i-1]==' ')
            {
                stringResult=stringResult+tempStr.toUpperCase();
            }
            if (i!=0 && charStr[i-1]!=' ')
            {
                stringResult=stringResult+tempStr;
            }

        }

        System.out.println(stringResult);
    }
}
