package com.javarush.test.level33.lesson15.big01.strategies;

import com.javarush.test.level33.lesson15.big01.ExceptionHandler;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by Alenka on 08.06.2016.
 */
public class FileBucket {

    private Path path;

    public FileBucket() {
        try {
            path = Files.createTempFile("tmp", null); //9.3.1.	Инициализировать path временным файлом. Файл должен быть размещен в директории для временных файлов и иметь случайное имя. Подсказка: Files.createTempFile.
        }
        catch (IOException e) {
            ExceptionHandler.log(e);
        }
        path.toFile().deleteOnExit(); //9.3.3.	Обеспечивать удаление файла при выходе из программы. Подсказка:        deleteOnExit().
    }

//    9.4.1.	long getFileSize(), он должен возвращать размер файла на который     указывает path.
    public long getFileSize() {
        return path.toFile().length();
    }

//    9.4.2.	void putEntry(Entry entry) - должен сериализовывать переданный entry в     файл. Учти, каждый entry может содержать еще один entry.
    public void putEntry(Entry entry) {
        try {
            FileOutputStream fos = new FileOutputStream(path.toFile());
            ObjectOutputStream outputStream = new ObjectOutputStream(fos);
            outputStream.writeObject(entry);
            fos.close();
            outputStream.close();
        }
        catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }

//    9.4.3.	Entry getEntry() - должен забирать entry из файла. Если файл имеет нулевой     размер, вернуть null.
    public Entry getEntry() {
        Entry entry = null;
        if (getFileSize() > 0) {
            try {
                FileInputStream fis = new FileInputStream(path.toFile());
                ObjectInputStream inputStream = new ObjectInputStream(fis);
                entry = (Entry)inputStream.readObject();
                fis.close();
                inputStream.close();
            }
            catch (Exception e) {
                ExceptionHandler.log(e);
            }
        }
        return entry;
    }


//    9.4.4.	void remove() – удалять файл на который указывает path.     Конструктор и методы не должны кидать исключения.
    public void remove() {
        try {
            Files.delete(path);
        }
        catch (IOException e) {
            ExceptionHandler.log(e);
        }
    }




}
