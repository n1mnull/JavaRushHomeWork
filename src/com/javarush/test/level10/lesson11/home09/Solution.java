package com.javarush.test.level10.lesson11.home09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* Одинаковые слова в списке
Ввести с клавиатуры в список 20 слов. Нужно подсчитать количество одинаковых слов в списке.
Результат нужно представить в виде словаря Map<String, Integer>, где первый параметр – уникальная строка,
а второй – число, сколько раз данная строка встречалась в списке.
Вывести содержимое словаря на экран.
В тестах регистр (большая/маленькая буква) не влияет на результат.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> words = new ArrayList<String>();
        for (int i = 0; i < 20; i++)
        {
            words.add(reader.readLine());
        }
        /*
        words.add("как");
        words.add("полупроводниковой");
        words.add("применением");
        words.add("как");
        words.add("производство");
        words.add("продукции");
        words.add("производительности");
        words.add("оптимизированного");
        words.add("года");
        words.add("производство");

        words.add("ресурс");
        words.add("продукции");
        words.add("технологии");
        words.add("планировалось");
        words.add("выпуск");
        words.add("нормам");
        words.add("производительности");
        words.add("критерию");
        words.add("года");
        words.add("производство");
        */

        Map<String, Integer> map = countWords(words);

        for (Map.Entry<String, Integer> pair : map.entrySet())
        {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }

    public static Map<String, Integer> countWords(ArrayList<String> list)
    {
        HashMap<String, Integer> result = new HashMap<String, Integer>();

        result.put(list.get(0),1);
        for (int i=1;i<list.size();i++)
        {
            boolean isPresent=false;
            for (Map.Entry<String, Integer> pair : result.entrySet())
            {
                if (pair.getKey().equals(list.get(i)))
                {
                    int temp=pair.getValue().intValue()+1;
                    pair.setValue(temp);
                    isPresent=true;
                }
            }
            if (!isPresent)
            {
                result.put(list.get(i),1);
            }
        }
        return result;
    }

}
