package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

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
    public static void main(String[] args) throws Exception {

        String productName = "";
        if (args[1].length() >= 30) {
            productName = args[1].substring(0,30);
        } else {
            productName = args[1];
            for (int i = 0; i < 30 - args[1].length(); i++)
                productName = productName + " ";
        }

        String price;
        if (args[2].length() >= 8) {
            price = args[2].substring(0,8);
        } else {
            price = args[2];
            for (int i = 0; i < 8 - args[2].length(); i++)
                price = price + " ";
        }

        String quantity;
        if (args[3].length() >= 4) {
            quantity = args[3].substring(0,4);
        } else {
            quantity = args[3];
            for (int i = 0; i < 4 - args[3].length(); i++)
                quantity = quantity + " ";
        }


        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();

        BufferedReader bufferedReaderFile = new BufferedReader(new FileReader(fileName));
        String readStr;
        ArrayList<String> arrayList = new ArrayList<>();

        while ((readStr = bufferedReaderFile.readLine()) != null) {
            arrayList.add(readStr);
            if (arrayList.size() == 1) {
                arrayList.remove(0);
                arrayList.add(readStr.substring(1,readStr.length()));
            }
        }
        bufferedReaderFile.close();

        int previousId = Integer.parseInt(arrayList.get(arrayList.size()-1).substring(0,8).split(" ")[0]);

        String id="";
        String currentId = String.valueOf(previousId+1);
        if (currentId.length() >= 8) {
            id = currentId.substring(0,8);
        } else {
            id = currentId;
            for (int i = 0; i < 8 - currentId.length(); i++)
                id = id + " ";
        }

        BufferedWriter bufferedWriterFile = new BufferedWriter(new FileWriter(fileName,true));
        bufferedWriterFile.write(id + productName + price + quantity);
        bufferedWriterFile.close();

    }
}
