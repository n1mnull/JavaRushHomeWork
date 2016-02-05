package com.javarush.test.level18.lesson03.task05;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;




/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
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

        int max = 0;
        int maxJ = 0;
        int tempInt = 0;

        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0) continue;
            for (int j = i; j < count.length; j++) {
                if (count[j] > max && count[j] != 0) {
                    max = count[j];
                    maxJ = j;
                }
                tempInt = count[i];
                count[i] = count[maxJ];
                count[maxJ] = tempInt;
            }
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) System.out.println(i);
        }
    }
}
