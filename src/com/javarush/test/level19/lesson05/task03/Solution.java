package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException
    {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String inFileName = bufferedReader.readLine();
        String outFileName = bufferedReader.readLine();
        bufferedReader.close();

        ArrayList<String> allString = new ArrayList<>();
        BufferedReader bufferedReader1 = new BufferedReader(new FileReader(inFileName));
        String tempStr;
        while ((tempStr = bufferedReader1.readLine()) != null) {
            allString.add(tempStr);
        }
        bufferedReader1.close();

        String[] arr;
        String outputStr = "";
        for (int i = 0; i < allString.size(); i++) {
            arr = allString.get(i).split(" ");

            for (int j = 0; j < arr.length ; j++) {
                if (arr[j].equals(arr[j].replaceAll("[^0-9]","")) && !arr[j].equals("")) {
                    outputStr = outputStr + " " + arr[j];
                }
            }
        }

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outFileName));
        bufferedWriter.write(outputStr.substring(1));
        bufferedWriter.close();
    }
}
