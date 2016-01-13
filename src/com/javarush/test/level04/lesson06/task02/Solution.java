package com.javarush.test.level04.lesson06.task02;

/* Максимум четырех чисел
Ввести с клавиатуры четыре числа, и вывести максимальное из них.
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
        int d = scanner.nextInt();

        if (a > b && a > c && a > d) {System.out.println(a);}
        if (b > a && b > c && b > d) {System.out.println(b);}
        if (c > b && c > a && c > d) {System.out.println(c);}
        if (d > b && d > c && d > a) {System.out.println(d);}



    }


}

