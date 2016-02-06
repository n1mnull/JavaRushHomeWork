package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream fileInputStream = new FileInputStream(bufferedReader.readLine());

        FileOutputStream fileOutputStream = new FileOutputStream(bufferedReader.readLine());

        if (fileInputStream.available() > 0)
        {

            byte inputByteArray[] = new byte[fileInputStream.available()];
            byte outputByteArray[] = new byte[fileInputStream.available()];

            int count = fileInputStream.read(inputByteArray);

            for (int i = 0; i < count; i++) outputByteArray[i] = inputByteArray[count-i-1];

            fileOutputStream.write(outputByteArray);
        }

        bufferedReader.close();
        fileInputStream.close();
        fileOutputStream.close();
    }
}

