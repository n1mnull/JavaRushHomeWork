package com.javarush.test.level19.lesson10.bonus02;

/* Свой FileWriter
Реализовать логику FileConsoleWriter
Должен наследоваться от FileWriter
При записи данных в файл, должен дублировать эти данные на консоль
*/

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;

public class FileConsoleWriter extends FileWriter
{

    public FileConsoleWriter(FileDescriptor fd) {
        super(fd);
    }

    public FileConsoleWriter(File file) throws IOException {
        super(file);
    }

    public FileConsoleWriter(File file, boolean append) throws IOException {
        super(file, append);
    }

    public FileConsoleWriter(String fileName) throws IOException {
        super(fileName);
    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException {
        super(fileName, append);
    }

    @Override
    public void write(int c) throws IOException {
        char[] var2 = new char[]{(char)c};
        this.write(var2, 0, 1);
    }

    @Override
    public void write(char[] cbuf, int off, int len) throws IOException {
        String x = new String(cbuf,off,len);
        write(x);
    }

    @Override
    public void write(String str, int off, int len) throws IOException {
        String x = new String(str.toCharArray(),off,len);
        System.out.print(x);
        super.write(str, off, len);
    }
}