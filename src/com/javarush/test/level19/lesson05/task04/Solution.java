package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки. Не использовать try-with-resources
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

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outFileName));
        for (int i = 0; i < allString.size(); i++) {
            bufferedWriter.write(allString.get(i).replace(".","!"));
        }
        bufferedWriter.close();
    }
}
