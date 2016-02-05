package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName = reader.readLine();

        FileInputStream inputStream = new FileInputStream(fileName);

        int count[] = new int[255];


        while (inputStream.available() > 0) {
            int data = inputStream.read();
            count[data]++;
        }
        inputStream.close();
        int min = count.length;

        for (int i = 0; i < count.length; i++) {
            if (count[i] < min && count[i] != 0) min = count[i];
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] == min) System.out.println(i);
        }
    }
}
