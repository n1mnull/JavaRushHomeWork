package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException
    {

        if (args[0].equals("-e")) {
            Encrypt(args[1],args[2]);
        } else if (args[0].equals("-d")) {
            Decrypt(args[1], args[2]);
        }

    }

    private static void Encrypt(String fileNameInput, String fileNameOutput) throws IOException
    {
        FileOutputStream fileOutputStream = new FileOutputStream(fileNameOutput);
        FileInputStream fileInputStream = new FileInputStream(fileNameInput);
        byte buffer[] = new byte[fileInputStream.available()];
        fileInputStream.read(buffer);
        fileInputStream.close();
        for (int i = 0; i < buffer.length; i++)
            buffer[i]++;
        fileOutputStream.write(buffer);
        fileOutputStream.close();
    }

    private static void Decrypt(String fileNameInput, String fileNameOutput) throws IOException
    {
        FileOutputStream fileOutputStream = new FileOutputStream(fileNameOutput);
        FileInputStream fileInputStream = new FileInputStream(fileNameInput);
        byte buffer[] = new byte[fileInputStream.available()];
        fileInputStream.read(buffer);
        fileInputStream.close();
        for (int i = 0; i < buffer.length; i++)
            buffer[i]--;
        fileOutputStream.write(buffer);
        fileOutputStream.close();
    }

}
