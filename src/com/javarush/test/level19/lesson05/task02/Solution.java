package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException
    {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        String fileName = bufferedReader.readLine();
        String fileName = "y:/190502.txt";
        bufferedReader.close();

        FileInputStream inputStream = new FileInputStream(fileName);
        String allWordsString = "";
        if (inputStream.available() > 0) {
            byte[] bufferIn = new byte[inputStream.available()];
            inputStream.read(bufferIn);
            allWordsString = new String(bufferIn);
        }
        inputStream.close();


        System.out.println(allWordsString);
//        allWordsString = allWordsString.replaceAll("[^A-Za-z0-9]", " ");
        allWordsString = allWordsString.replaceAll("\\p{Punct}"," ");
        System.out.println(allWordsString);

        System.out.println("Begin count");
        String[] arr = allWordsString.split(" ");
        int count = 0;
        for (int i = 0; i <arr.length ; i++) {

            if (arr[i].equals("world")) {
                count++;
                System.out.println(arr[i] + " - " + count);
            }else System.out.println(arr[i]);
        }
        System.out.println(count);

    }
}
