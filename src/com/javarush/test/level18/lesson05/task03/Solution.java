package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream fileInputStream1 = new FileInputStream(bufferedReader.readLine());

        FileOutputStream fileOutputStream1 = new FileOutputStream(bufferedReader.readLine());

        FileOutputStream fileOutputStream2 = new FileOutputStream(bufferedReader.readLine());

        if (fileInputStream1.available() > 0) {
            //читаем весь файл одним куском
            byte[] buffer = new byte[fileInputStream1.available()];
            int count = fileInputStream1.read(buffer);

            if (buffer.length % 2 == 0) {
                fileOutputStream1.write(buffer, 0, count / 2);
                fileOutputStream2.write(buffer, count / 2, count / 2);
            } else {
                fileOutputStream1.write(buffer, 0, count / 2 + 1);
                fileOutputStream2.write(buffer, count / 2 + 1, count / 2);
            }
        }

        bufferedReader.close();
        fileInputStream1.close();
        fileOutputStream1.close();
        fileOutputStream2.close();

    }
}
