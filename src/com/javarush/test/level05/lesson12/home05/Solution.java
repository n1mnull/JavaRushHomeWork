package com.javarush.test.level05.lesson12.home05;

/* Вводить с клавиатуры числа и считать их сумму
Вводить с клавиатуры числа и считать их сумму, пока пользователь не введёт слово «сумма». Вывести на экран полученную сумму.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int sum = 0;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true)
        {
            String sNumber = reader.readLine();

            if (sNumber.equals("сумма"))
            {
                break;
            }

            int nNumber = Integer.parseInt(sNumber);
            sum = sum + nNumber;

        }

        System.out.println(sum);

    }
}
