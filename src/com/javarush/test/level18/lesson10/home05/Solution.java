package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = bufferedReader.readLine();
        String fileName2 = bufferedReader.readLine();
        bufferedReader.close();

        ArrayList<Integer> numbers = new ArrayList<Integer>();
        BufferedReader bufferedFileReader = new BufferedReader(new FileReader(fileName1));
        String readString;
        String[] numberArray;
        String writeString = "";

        while ((readString = bufferedFileReader.readLine()) != null) {

            numberArray = readString.split(" ");
            for (int i = 0; i < numberArray.length; i++) {
                numbers.add((int) Math.round(Double.parseDouble(numberArray[i])));
                writeString = writeString + Math.round(Double.parseDouble(numberArray[i])) + " ";
            }
        }
        writeString = writeString.substring(0,writeString.length()-1);
        BufferedWriter bufferedFileWriter = new BufferedWriter(new FileWriter(fileName2));
        bufferedFileWriter.write(writeString);
        bufferedFileWriter.close();
        bufferedFileReader.close();

    }
}
