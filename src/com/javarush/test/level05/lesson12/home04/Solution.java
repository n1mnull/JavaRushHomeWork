package com.javarush.test.level05.lesson12.home04;

/* Вывести на экран сегодняшнюю дату
Вывести на экран текущую дату в аналогичном виде "21 02 2014".
*/

public class Solution
{
    public static void main(String[] args)
    {
     //   long time = System.currentTimeMillis();
        int day = 12;
        int month = 9;
        int year = 2015;
        if (month<10)
            System.out.println(day + " 0"+ month + " "+ year);
        else System.out.println(day + " "+ month + " "+ year);
    }
}
