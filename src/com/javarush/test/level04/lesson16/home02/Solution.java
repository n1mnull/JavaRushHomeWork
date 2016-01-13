package com.javarush.test.level04.lesson16.home02;

import java.io.*;
import java.util.Scanner;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        if (m > n && m < k) System.out.println(m);
        if (m < n && m > k) System.out.println(m);

        if (n > m && n < k) System.out.println(n);
        if (n < m && n > k) System.out.println(n);

        if (k > n && k < m) System.out.println(k);
        if (k < n && k > m) System.out.println(k);
    }
}
