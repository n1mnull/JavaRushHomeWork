package com.javarush.test.level18.lesson10.home07;

/* Поиск данных внутри файла
Считать с консоли имя файла
Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int)
Закрыть потоки. Не использовать try-with-resources

В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity

где id - int
productName - название товара, может содержать пробелы, String
price - цена, double
quantity - количество, int

Информация по каждому товару хранится в отдельной строке
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        int id = Integer.parseInt(args[0]);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileInputStream = new BufferedReader(new FileReader(bufferedReader.readLine()));

        String tempString;
        ArrayList<String> productArray = new ArrayList<>();

        while ((tempString = fileInputStream.readLine()) != null) {
            productArray.add(tempString);
        }

        String[] splitString;

        for (int i = 0; i < productArray.size(); i++) {

            splitString = productArray.get(i).split(" ");

            if (Integer.parseInt(splitString[0]) == id) {

                System.out.println(productArray.get(i));
            }
        }
        bufferedReader.close();
        fileInputStream.close();
    }
}
