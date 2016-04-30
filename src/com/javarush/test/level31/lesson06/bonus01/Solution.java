package com.javarush.test.level31.lesson06.bonus01;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* Разархивируем файл
В метод main приходит список аргументов.
Первый аргумент - имя результирующего файла resultFileName, остальные аргументы - имена файлов fileNamePart.
Каждый файл (fileNamePart) - это кусочек zip архива. Нужно разархивировать целый файл, собрав его из кусочков.
Записать разархивированный файл в resultFileName.
Архив внутри может содержать файл большой длины, например, 50Mb.
Внутри архива может содержаться файл с любым именем.

Пример входных данных. Внутри архива находится один файл с именем abc.mp3:
C:/result.mp3
C:/pathToTest/test.zip.003
C:/pathToTest/test.zip.001
C:/pathToTest/test.zip.004
C:/pathToTest/test.zip.002
*/
public class Solution {
    public static void main(String[] args) throws IOException
    {
        File resultFile = new File(args[0]);
        ArrayList<File> files = new ArrayList<>();
        for (int i = 1; i < args.length; i++) {
            files.add(new File(args[i]));
        }
        Collections.sort(files); //Имена могут приходить в случайном порядке.
        byte[] buffer = new byte[1024];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (File f : files) {
            FileInputStream fileInputStream = new FileInputStream(f);
            while (fileInputStream.read(buffer) > -1) {
                byteArrayOutputStream.write(buffer); //Пишем содержимое всех файлов в byteArrayOutputStream.
            }
            fileInputStream.close();
        }
        ZipInputStream zipInputStream = new ZipInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray())); //На основе содержимого byteArrayOutputStream создаем поток для чтения из архива.
        FileOutputStream fileOutputStream = new FileOutputStream(resultFile); //Поток для записи результата.
        ZipEntry zipEntry = zipInputStream.getNextEntry();
        while (zipEntry != null) {
            int count;
            while ((count = zipInputStream.read(buffer)) > -1) {
                fileOutputStream.write(buffer, 0, count); //В случае записи из архива используется именно такая запись.
            }
            zipEntry = zipInputStream.getNextEntry();
        }
        fileOutputStream.close();
        zipInputStream.close();
    }
}