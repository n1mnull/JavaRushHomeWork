package com.javarush.test.level05.lesson12.home03;

/* Создай классы Dog, Cat, Mouse
Создай классы Dog, Cat, Mouse. Добавь по три поля в каждый класс, на твой выбор. Создай объекты для героев мультика Том и Джерри. Так много, как только вспомнишь.
Пример:
Mouse jerryMouse = new Mouse(“Jerry”, 12 , 5), где 12 - высота в см, 5 - длина хвоста в см.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Mouse jerryMouse = new Mouse("Jerry", 12 , 5);
        Mouse tommyMouse = new Mouse("Tommy", 10 , 5);

        Cat tomCat = new Cat("Tom",3,"Black/white");
        Cat jasperCat = new Cat("Jasper",1,"Black");

        Dog bulDog = new Dog("Bul",5,"male");
        Dog kinderDog = new Dog("Kinder",2,"male");

    }

    public static class Mouse
    {
        String name;
        int height;
        int tail;

        public Mouse(String name, int height, int tail)
        {
            this.name = name;
            this.height = height;
            this.tail = tail;
        }
    }

    public static class Dog
    {
        String name;
        int age;
        String sex;

        public Dog(String name, int age, String sex)
        {
            this.name = name;
            this.age = age;
            this.sex = sex;
        }
    }

    public static class Cat
    {
        String name;
        int age;
        String color;

        public Cat(String name, int age, String color)
        {
            this.name = name;
            this.age = age;
            this.color = color;
        }
    }

}
