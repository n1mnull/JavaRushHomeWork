package com.javarush.test.level20.lesson10.home03;

import java.io.*;

/* Найти ошибки
Почему-то при сериализации/десериализации объекта класса B возникают ошибки.
Найдите проблему и исправьте ее.
Класс A не должен реализовывать интерфейсы Serializable и Externalizable.
Сигнатура класса В не содержит ошибку :)
Метод main не участвует в тестировании.
*/
public class Solution implements Serializable{
    public static class A {

        public A() {}
        protected String name = "A";
        public A(String name) {
            this.name += name;
        }
    }

    public class B extends A implements Serializable {
        public B(String name) {
            super(name);
            this.name += name;
        }

        private void writeObject(ObjectOutputStream out) throws Exception{
            out.writeObject(this.name);
        }

        private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException{
            this.name = (String) in.readObject();
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("y://201003.txt"));
        B b = new Solution().new B("bName");
        oos.writeObject(b);
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("y://201003.txt"));
        b = (B)ois.readObject();
        System.out.println(b.name);
    }
}
