package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String tempStr;
        ArrayList<String> list = new ArrayList<>();

        while (!(tempStr = bufferedReader.readLine()).equals("end")) {
            list.add(tempStr);
        }
        bufferedReader.close();

        String fileName = list.get(0).substring(0,list.get(0).lastIndexOf(".part"));

        int min, minj;
        for (int i = 0; i < list.size(); i++) {
            min = getNumber(list.get(i));
            minj = i;
            for (int j = i; j < list.size(); j++) {
                if (getNumber(list.get(j)) < min ){
                   min =  getNumber(list.get(j));
                   minj = j;
                }
            }
            tempStr = list.get(i);
            list.add(i, list.get(minj));
            list.remove(minj + 1);
            list.add(minj,tempStr);
            list.remove(i + 1);
        }

        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        for (int i = 0; i < list.size(); i++)
        {
            FileInputStream fileInputStream = new FileInputStream(list.get(i));
            byte buffer[] = new byte[fileInputStream.available()];
            fileInputStream.read(buffer);
            fileInputStream.close();
            fileOutputStream.write(buffer);
        }
        fileOutputStream.close();
    }

    public static int getNumber(String str) {
        return Integer.parseInt(str.substring(str.lastIndexOf(".part")+5,str.length()));
    }
}

