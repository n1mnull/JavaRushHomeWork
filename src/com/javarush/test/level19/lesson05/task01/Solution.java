package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
Закрыть потоки ввода-вывода.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String inFileName = bufferedReader.readLine();
        String outFileName = bufferedReader.readLine();
        bufferedReader.close();

        FileInputStream inputStream = new FileInputStream(inFileName);
        FileOutputStream outputStream = new FileOutputStream(outFileName);
        String outString = "";
        if (inputStream.available() > 0) {
            byte[] bufferIn = new byte[inputStream.available()];
            inputStream.read(bufferIn);
            for (int i = 1; i < bufferIn.length; i=i+2)
                outString = outString + (char)bufferIn[i];
            outputStream.write(outString.getBytes());
        }
        inputStream.close();
        outputStream.close();

    }
}
