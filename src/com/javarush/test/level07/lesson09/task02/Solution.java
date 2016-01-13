package com.javarush.test.level07.lesson09.task02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* Слова в обратном порядке
Введи с клавиатуры 5 слов в список строк. Удали 3 - ий элемент списка, и выведи оставшиеся элементы в обратном порядке.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        ArrayList<String> listString = new ArrayList<String>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i=0;i<5;i++){
            listString.add(reader.readLine());}

      //  System.out.println(listString.size());
        listString.remove(2);
      //  System.out.println(listString.size());

        for (int i=0;i<listString.size();i++){
            System.out.println(listString.get(listString.size()-i-1));
        }

    }
}
