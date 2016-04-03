package com.javarush.test.level20.lesson10.home07;

import java.io.*;

/* Переопределение сериализации в потоке
Сериализация/десериализация Solution не работает.
Исправьте ошибки не меняя сигнатуры методов и класса.
Метод main не участвует в тестировании.
Написать код проверки самостоятельно в методе main:
1) создать экземпляр класса Solution
2) записать в него данные  - writeObject
3) сериализовать класс Solution  - writeObject(ObjectOutputStream out)
4) десериализовать, получаем новый объект
5) записать в новый объект данные - writeObject
6) проверить, что в файле есть данные из п.2 и п.5
*/
public class Solution implements Serializable, AutoCloseable {

    public static void main (String[] args) throws Exception
    {
        Solution solution1 = new Solution("y://201007_01.txt");
        solution1.writeObject("writeObject01");
        solution1.close();
        //SAVE
        FileOutputStream fileOutputStream = new FileOutputStream("y://201007_02.txt");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
        outputStream.writeObject(solution1);
        outputStream.flush();
        outputStream.close();
        fileOutputStream.close();
        //LOAD
        FileInputStream fileInputStream = new FileInputStream("y://201007_02.txt");
        ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
        Solution solution2 = (Solution) inputStream.readObject();
        inputStream.close();
        fileInputStream.close();
        solution2.writeObject("writeObject02");
        solution2.writeObject("writeObject03");
        solution2.close();

    }

    private transient FileOutputStream stream;
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        this.stream = new FileOutputStream(fileName);
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
//        out.close();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
//        in.close();
        stream = new FileOutputStream(fileName, true);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }
}
