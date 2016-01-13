package com.javarush.test.level09.lesson11.home09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* Десять котов
Создать класс кот – Cat, с полем «имя» (String).
Создать словарь Map(<String, Cat>) и добавить туда 10 котов в виде «Имя»-«Кот».
Получить из Map множество(Set) всех имен и вывести его на экран.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap() throws IOException
    {
//        BufferedReader readCat = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Cat> newMapCat = new HashMap<String, Cat>();

//        String catName;

        for (int i = 0; i < 10; i++)
        {
//            catName = readCat.readLine();
            newMapCat.put("catName "+i, new Cat("catName "+i));
        }
        return newMapCat;//напишите тут ваш код
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map)
    {
        Set<Cat> newSetCat = new HashSet<Cat>();

        for (Map.Entry<String, Cat> pair : map.entrySet())
        {
            Cat value = pair.getValue();                  //значение
            newSetCat.add(value);
        }

        return newSetCat;
    }

    public static void printCatSet(Set<Cat> set)
    {
        for (Cat cat:set)
        {
            System.out.println(cat);
        }
    }

    public static class Cat
    {
        private String name;

        public Cat(String name)
        {
            this.name = name;
        }

        public String toString()
        {
            return "Cat "+this.name;
        }
    }


}
