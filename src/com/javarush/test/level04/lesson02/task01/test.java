package com.javarush.test.level04.lesson02.task01;

/**
 * Created by Alenka on 07.09.2015.
 */
public class test
{
    public static void main(String[] args)
    {
       // public static int count = 0;     //объявили переменную класса
       // System.out.println("1: "+count);

        //public void run()
        {
            //int count = 15;           //обращение к переменной класса
          //  System.out.println("2: "+count);
            int count = 10;       //объявили локальную переменную метода
            System.out.println("3: "+count);
            count ++;             //обращение к переменной метода
            System.out.println("4: "+count);
        }
    }

}
