package com.javarush.test.level07.lesson09.task03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* Слово «именно»
1. Создай список из слов «мама», «мыла», «раму».
2. После каждого слова вставь в список строку, содержащую слово «именно».
3. Используя цикл for вывести результат на экран, каждый элемент списка с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        ArrayList<String> listString = new ArrayList<String>();

        listString.add("мама");//0
        listString.add("мыла");//2
        listString.add("раму");//4

        for (int i=0;i<3;i++){
          //  System.out.println(listString.get(i));
            listString.add(i*2+1,"именно");}

        for (int i=0;i<listString.size();i++){
            System.out.println(listString.get(i));}

    }
}
