package com.javarush.test.level08.lesson08.task05;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{

    /*public static void main(String[] args)
    {
        HashMap<String,String> stringStringHashMap = createMap();
        for (Map.Entry<String, String> pair1: stringStringHashMap.entrySet()){
            System.out.println(pair1.getKey()+" - "+pair1.getValue());
        }

        removeTheFirstNameDuplicates(stringStringHashMap);

        System.out.println("--------");

        for (Map.Entry<String, String> pair1: stringStringHashMap.entrySet()){
            System.out.println(pair1.getKey()+" - "+pair1.getValue());
        }

    }*/

    public static HashMap<String, String> createMap()
    {
        HashMap<String,String> stringStringHashMap = new HashMap<String, String>();

        stringStringHashMap.put("1Ivanova", "Petro");
        stringStringHashMap.put("2Ivanov", "Petro");
        stringStringHashMap.put("3Ivanova", "Lida");
        stringStringHashMap.put("4Sidorenko", "Petro");
        stringStringHashMap.put("5Ivanov", "Ivan");
        stringStringHashMap.put("6Deer", "John");
        stringStringHashMap.put("7Butkova", "Kate");
        stringStringHashMap.put("8II", "Johan");
        stringStringHashMap.put("9Kiselev", "Sergey");
        stringStringHashMap.put("10Ponomarev", "Ivan");

        return stringStringHashMap;

    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair1: copy.entrySet())
        {
            int counter=0;
            for (Map.Entry<String, String> pair2: copy.entrySet())
            {
                if (pair1.getValue().equals(pair2.getValue()))
                {
                     counter++;
                }
            }
            if (counter>1)
            {
                removeItemFromMapByValue(map,pair1.getValue());
            }

        }
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }
}
