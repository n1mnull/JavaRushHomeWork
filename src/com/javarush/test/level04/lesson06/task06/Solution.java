package com.javarush.test.level04.lesson06.task06;

/* И 18-ти достаточно
Ввести с клавиатуры имя и возраст. Если возраст больше 20 вывести надпись «И 18-ти достаточно».
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

        if (age > 20) {
            System.out.println("И 18-ти достаточно");
        }

    }
}
