package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        FileOutputStream fileOutputStream = new FileOutputStream(bufferedReader.readLine(),true);

        FileInputStream fileInputStream1 = new FileInputStream(bufferedReader.readLine());

        FileInputStream fileInputStream2 = new FileInputStream(bufferedReader.readLine());


        byte buffer1[] = new byte[fileInputStream1.available()];
        fileInputStream1.read(buffer1);
        fileInputStream1.close();

        byte buffer2[] = new byte[fileInputStream2.available()];
        fileInputStream2.read(buffer2);
        fileInputStream2.close();


        fileOutputStream.write(buffer1);
        fileOutputStream.write(buffer2);
        fileOutputStream.close();

        bufferedReader.close();
    }
}
