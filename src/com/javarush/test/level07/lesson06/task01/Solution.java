package com.javarush.test.level07.lesson06.task01;

import java.util.ArrayList;

/* 5 различных строчек в списке
1. Создай список строк.
2. Добавь в него 5 различных строчек.
3. Выведи его размер на экран.
4. Используя цикл выведи его содержимое на экран, каждое значение с новой строки.
*/
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        ArrayList<String> listString = new ArrayList<String>();

        listString.add("ExampleText1");
        listString.add("ExampleText2");
        listString.add("ExampleText3");
        listString.add("ExampleText4");
        listString.add("ExampleText5");

        System.out.println(listString.size());

        for (int i = 0; i < listString.size(); i++){
        System.out.println(listString.get(i));
    }

    }
}
