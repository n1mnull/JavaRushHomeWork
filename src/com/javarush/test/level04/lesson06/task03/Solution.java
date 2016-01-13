package com.javarush.test.level04.lesson06.task03;

/* Сортировка трех чисел
Ввести с клавиатуры три числа, и вывести их в порядке убывания.
*/

import java.io.*;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        if (a > b && a > c && b > c) {System.out.println(a+" "+b+" "+c);}
        if (a > b && a > c && c > b) {System.out.println(a+" "+c+" "+b);}

        if (b > a && b > c && a > c) {System.out.println(b+" "+a+" "+c);}
        if (b > a && b > c && c > a) {System.out.println(b+" "+c+" "+a);}

        if (c > b && c > a && a > b) {System.out.println(c+" "+a+" "+b);}
        if (c > b && c > a && b > a) {System.out.println(c+" "+b+" "+a);}


    }
}
