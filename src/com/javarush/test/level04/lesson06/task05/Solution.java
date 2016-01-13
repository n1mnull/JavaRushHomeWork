package com.javarush.test.level04.lesson06.task05;

/* 18+
Ввести с клавиатуры имя и возраст. Если возраст меньше 18 вывести надпись «Подрасти еще».
*/

import java.io.*;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int age = scanner.nextInt();

        if (age < 18) {
            System.out.println("Подрасти еще");
        }

    }
}
