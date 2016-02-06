package com.javarush.test.level18.lesson05.task05;

/* DownloadException
1 Считывать с консоли имена файлов.
2 Если файл меньше 1000 байт, то:
2.1 Закрыть потоки
2.2 выбросить исключение DownloadException
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException
    {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<FileInputStream> fileInputStreams = new ArrayList<FileInputStream>();

        int count = 0;

        while (true) {

            fileInputStreams.add(new FileInputStream(bufferedReader.readLine()));

            if (fileInputStreams.get(count).available() < 1000 ) {

                for (int i = 0; i <= count; i++) {
                    fileInputStreams.get(i).close();
                }
                throw new DownloadException();
            }
            count++;

        }
    }

    public static class DownloadException extends Exception{

    }
}
