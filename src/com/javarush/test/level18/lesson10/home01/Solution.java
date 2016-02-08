package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        FileInputStream fileInputStream = new FileInputStream(args[0]);

        byte[] buffer = null;

        if (fileInputStream.available() > 0) {
            //читаем весь файл одним куском
            buffer = new byte[fileInputStream.available()];
            fileInputStream.read(buffer);
        }

        String text = new String(buffer).toLowerCase();

        int countAlfabet=0;

        for (int i = 0; i < text.length(); i++)
            if (text.charAt(i) >= 97 && text.charAt(i) <= 122 ) countAlfabet++;

        System.out.println(countAlfabet);
        fileInputStream.close();


    }
}
