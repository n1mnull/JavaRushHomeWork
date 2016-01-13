package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой стороки.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String fileName = bufferedReader.readLine();

        FileWriter outStream = new FileWriter(fileName);


//        System.out.println("File connected...");
//
//        System.out.println("Enter your information for write it to file " + fileName + ". For exit type - 'exit'");

        String stringWrite = bufferedReader.readLine();

        while (true) {

            outStream.write(stringWrite);
            outStream.write(System.lineSeparator());
            if (stringWrite.equals("exit")) break;
            stringWrite = bufferedReader.readLine();

        }

        bufferedReader.close();
        outStream.close();



    }
}
