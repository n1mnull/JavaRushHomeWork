package com.javarush.test.level19.lesson05.task05;

/* Пунктуация
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Удалить все знаки пунктуации, включая символы новой строки. Результат вывести во второй файл.
http://ru.wikipedia.org/wiki/%D0%9F%D1%83%D0%BD%D0%BA%D1%82%D1%83%D0%B0%D1%86%D0%B8%D1%8F
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException
    {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        String inFileName = "y://190505.in.txt";
//        String outFileName = "y://190505.out.txt";
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

        for (int i = 0; i < allString.size(); i++){
            tempStr = allString.get(i).replaceAll("\\p{Punct}", "");
            bufferedWriter.write(tempStr);
        }
        bufferedWriter.close();
    }
}
