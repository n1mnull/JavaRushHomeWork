package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName = reader.readLine();

        FileInputStream inputStream = new FileInputStream(fileName);

        int count[] = new int[255];
        int max = 0;

        while (inputStream.available() > 0) {
            int data = inputStream.read();
            count[data]++;
            if (count[data] > max) max = count[data];
        }
        inputStream.close();

        for (int i = 0; i < count.length; i++) {
            if (count[i] == max) System.out.println(i);
        }



    }
}
