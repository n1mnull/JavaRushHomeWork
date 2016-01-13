package com.javarush.test.level10.lesson04.task02;

/* Задача №2 на преобразование целых типов
Расставьте правильно операторы приведения типа, чтобы получился ответ: d=3.765
int a = 15;
int b = 4;
float c = a / b;
double d = a * 1e-3 + c;
*/

public class Solution
{
    public static void main(String[] args)
    {
        int a = 15;
      //  System.out.println(a);
        int b = 4;
      //  System.out.println(b);
        float c = (float)(a * 1.0 / b);
      //  System.out.println(c);
        double d = a * 1e-3 + c;

        System.out.println(d);
    }
}
