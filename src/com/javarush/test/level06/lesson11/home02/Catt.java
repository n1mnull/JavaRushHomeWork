package com.javarush.test.level06.lesson11.home02;

import java.util.ArrayList;

/* Статические коты
1. В классе Cat добавь public статическую переменную cats (ArrayList<Cat>).
2. Пусть при каждом создании кота (нового объекта Cat) в переменную cats добавляется этот новый кот. Создать 10 объектов Cat.
3. Метод printCats должен выводить всех котов на экран. Нужно использовать переменную cats.
*/

public class Catt {

    public static ArrayList<Catt> cats = new ArrayList<Catt>();

    public Catt() {
    }

    public static void main(String[] args) {
        for (int i=0;i<10;i++){
            cats.add(new Catt()); }
        printCats();
    }

    public static void printCats() {
        for (int i=0;i<10;i++){
            System.out.println(cats.get(i));
        }
    }
}
