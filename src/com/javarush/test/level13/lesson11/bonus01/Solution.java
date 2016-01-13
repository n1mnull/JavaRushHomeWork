package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;


public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferFileName = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferFileName.readLine();

        BufferedReader bufferNumber = new BufferedReader(new FileReader(fileName));
        String readNumber;
        int array[] = new int[10000];
        int count = 0;
        while ((readNumber = bufferNumber.readLine()) != null)
        {
            if ((Integer.parseInt(readNumber) % 2) == 0)
            {
                array[count] = Integer.parseInt(readNumber);
                count++;
            }
        }
        int min;
        int minPosition;
        for (int i = 0; i < count; i++)
        {
            min = array[i];
            minPosition = i;
            for (int j = i; j < count; j++)
            {
                if (array[j] < min)
                {
                    min = array[j];
                    minPosition = j;
                }
            }
            array[minPosition] = array[i];
            array[i] = min;
            System.out.println(array[i]);

        }






    }
}
