package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    /*public static void main(String[] args)
    {
        HashMap<String,String> stringStringHashMap = new HashMap<String, String>();

        stringStringHashMap = createMap();

        for (Map.Entry<String, String> pair : stringStringHashMap.entrySet())
        {
            String key = pair.getKey();                      //ключ-lastname
            String value = pair.getValue();                  //значение-firstname
            System.out.println(key + ":" + value);
        }

        System.out.println(getCountTheSameFirstName(stringStringHashMap, "firstname1"));
        System.out.println(getCountTheSameLastName(stringStringHashMap, "lastname1"));
    }*/

    public static HashMap<String, String> createMap()
    {
        HashMap<String,String> stringStringHashMap = new HashMap<String, String>();

        for (int i=0;i<10;i++) {
            stringStringHashMap.put("lastname"+i,"firstname"+i);
        }
        return stringStringHashMap;

    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String firstname)
    {
        int CountTheSameFirstName = 0;

        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();

        while (iterator.hasNext())
        {
            Map.Entry<String, String> pair = iterator.next();
            String value = pair.getValue();
            if (value.equals(firstname)) CountTheSameFirstName++;
        }
        return CountTheSameFirstName;

    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastname)
    {
        int CountTheSameLastName = 0;

        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();

        while (iterator.hasNext())
        {
            Map.Entry<String, String> pair = iterator.next();
            String key = pair.getKey();
            if (key.equals(lastname)) CountTheSameLastName++;
        }

        return CountTheSameLastName;

    }
}
