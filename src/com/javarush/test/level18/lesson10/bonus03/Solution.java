package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static ArrayList<String> listString;

    public static void main(String[] args) throws IOException
    {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();

        listString = readStringFromFile(fileName);

        if (args[0].equals("-d")) {
            deleteProductById(args[1]);
            saveListToFile(fileName);
        }

        if (args[0].equals("-u")) {
            updateProductById(args[1], args[2], args[3], args[4]);
            saveListToFile(fileName);
        }
    }

    private static void updateProductById(String id, String productName, String price, String quantity) {

        String outputProductString = addSpace(id,8) + addSpace(productName,30) + addSpace(price,8) + addSpace(quantity,4);
        boolean update = false;
        for (int i = 0; i < listString.size(); i++)
            if (listString.get(i).substring(0,8).split(" ")[0].equals(id)) {
                listString.set(i,outputProductString);
                update = true;
            }
        if (update == false) listString.add(outputProductString);
    }

    private static String addSpace(String inputData, int lengthData) {
        String outputData="";

        if (inputData.length() >= lengthData) {
            outputData = inputData.substring(0,lengthData);
        } else {
            outputData = inputData;
            for (int i = 0; i < lengthData - inputData.length(); i++)
                outputData = outputData + " ";
        }
        return outputData;
    }

    private static void deleteProductById(String id){
        for (int i = 0; i < listString.size(); i++)
            if (listString.get(i).substring(0,8).split(" ")[0].equals(id))
                listString.remove(i);
    }

    private  static void saveListToFile(String fileName) throws IOException {
        BufferedWriter bufferedWriterFile = new BufferedWriter(new FileWriter(fileName));
        for (int i = 0; i < listString.size(); i++)
            bufferedWriterFile.write(listString.get(i));
        bufferedWriterFile.close();
    }

    private static ArrayList<String> readStringFromFile(String fileName) throws IOException {
        ArrayList<String> arrayList = new ArrayList<>();
        BufferedReader bufferedReaderFile = new BufferedReader(new FileReader(fileName));
        String readStr;

        while ((readStr = bufferedReaderFile.readLine()) != null) {
            if (arrayList.size() == 0) arrayList.add(readStr.substring(1, readStr.length()));
            else arrayList.add(readStr);
        }
        bufferedReaderFile.close();
        return arrayList;
    }

}


