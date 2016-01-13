package com.javarush.test.level08.lesson11.home01;

import java.util.HashSet;
import java.util.Set;

/* Set из котов
1. Внутри класса Solution создать public static класс кот – Cat.
2. Реализовать метод createCats, он должен создавать множество (Set) котов и добавлять в него 3 кота.
3. В методе main удалите одного кота из Set cats.
4. Реализовать метод printCats, он должен вывести на экран всех котов, которые остались во множестве. Каждый кот с новой строки.
*/

public class Solution
{
    static Cat cat1 = new Cat("Cat1");
    static Cat cat2 = new Cat("Cat2");
    static Cat cat3 = new Cat("Cat3");

    public static void main(String[] args)
    {

        Set<Cat> cats = createCats();

        printCats(cats);

        cats.remove(cat3);

        printCats(cats);
    }


    public static Set<Cat> createCats()
    {
        Set<Cat> catHashSet = new HashSet<Cat>();
        catHashSet.add(cat1);
        catHashSet.add(cat2);
        catHashSet.add(cat3);

        return catHashSet;
    }

    public static void printCats(Set<Cat> cats)
    {
        for (Cat setCat: cats) {
            System.out.println(setCat.name);
        }

    }

    public static class Cat
    {
        String name;

        public Cat(String name){
            this.name=name;
        }
    }
}
