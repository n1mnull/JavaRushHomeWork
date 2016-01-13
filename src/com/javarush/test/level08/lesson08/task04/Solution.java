package com.javarush.test.level08.lesson08.task04;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
   /* public static void main(String[] args)
    {
        HashMap<String,Date> stringDateHashMap = new HashMap<String, Date>();

        stringDateHashMap = createMap();

        for (Map.Entry<String, Date> pair : stringDateHashMap.entrySet())
        {
            String key = pair.getKey();                      //ключ-lastname
            Date value = pair.getValue();                  //значение-firstname
            System.out.println(key + ":" + value);
        }

        removeAllSummerPeople(stringDateHashMap);
        System.out.println();

        for (Map.Entry<String, Date> pair : stringDateHashMap.entrySet())
        {
            String key = pair.getKey();                      //ключ-lastname
            Date value = pair.getValue();                  //значение-firstname
            System.out.println(key + ":" + value);
        }
    }*/

    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", new Date("MARCH 1 1981"));
        map.put("qweqr1",new Date("JUNE 2 1982"));
        map.put("qweqr2",new Date("JUNE 3 1983"));
        map.put("qweqr3",new Date("JUNE 4 1984"));
        map.put("qweqr4",new Date("MARCH 5 1985"));
        map.put("qweqr5",new Date("FEBRUARY 6 1986"));
        map.put("qweqr6",new Date("JANUARY 7 1987"));
        map.put("qweqr7",new Date("AUGUST 8 1988"));
        map.put("qweqr8",new Date("JUNE 9 1989"));
        map.put("qweqr9",new Date("JULY 10 1990"));
        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();

        while (iterator.hasNext())
        {
            Map.Entry<String, Date> pair = iterator.next();
            Date value = pair.getValue();
            if (value.getMonth() > 4 && value.getMonth() < 8){
                iterator.remove();
            }
        }

    }
}
