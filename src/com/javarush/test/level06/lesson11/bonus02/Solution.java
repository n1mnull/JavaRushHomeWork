package com.javarush.test.level06.lesson11.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Нужно добавить в программу новую функциональность
Задача: У каждой кошки есть имя и кошка-мама. Создать класс, который бы описывал данную ситуацию. Создать два объекта: кошку-дочь и кошку-маму. Вывести их на экран.
Новая задача: У каждой кошки есть имя, кошка-папа и кошка-мама. Изменить класс Cat так, чтобы он мог описать данную ситуацию.
Создать 6 объектов: дедушку(папин папа), бабушку(мамина мама), папу, маму, сына, дочь.
Вывести их всех на экран в порядке: дедушка, бабушка, папа, мама, сын, дочь.

Пример ввода:
дедушка Вася
бабушка Мурка
папа Котофей
мама Василиса
сын Мурчик
дочь Пушинка

Пример вывода:
Cat name is дедушка Вася, no mother, no father
Cat name is бабушка Мурка, no mother, no father
Cat name is папа Котофей, no mother, father is дедушка Вася
Cat name is мама Василиса, mother is бабушка Мурка, no father
Cat name is сын Мурчик, mother is мама Василиса, father is папа Котофей
Cat name is дочь Пушинка, mother is мама Василиса, father is папа Котофей
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String stGrandFather = reader.readLine();
        Cat catGrandFather = new Cat(stGrandFather);

        String stGrandMother= reader.readLine();
        Cat catGrandMother = new Cat(stGrandMother);

        String stFather= reader.readLine();
        Cat catFather = new Cat(stFather,catGrandFather, null);

        String stMother= reader.readLine();
        Cat catMother = new Cat(stMother,null, catGrandMother);

        String stSon= reader.readLine();
        Cat catSon = new Cat(stSon,catFather, catMother);

        String stDouther= reader.readLine();
        Cat catDouther = new Cat(stDouther,catFather, catMother);

        System.out.println(catGrandFather);
        System.out.println(catGrandMother);
        System.out.println(catFather);
        System.out.println(catMother);
        System.out.println(catSon);
        System.out.println(catDouther);
    }

    public static class Cat
    {
        private String name;
        private Cat parentFather;
        private Cat parentMother;

        Cat(String name)
        {
            this.name = name;
        }

        Cat(String name, Cat parentFather, Cat parentMother)
        {
            this.name = name;
            if(parentFather!=null){
                this.parentFather = parentFather;
            }
            if(parentMother!=null){
                this.parentMother = parentMother;
            }
        }

        @Override
        public String toString()
        {
            String st = "";

            if (parentMother == null)
            {
                st = st+", no mother";
            } else {
                st= st+", mother is "+parentMother.name;
            }

            if (parentFather == null)
            {
                st = st+", no father";
            } else {
                st= st+", father is "+parentFather.name;
            }

            st="Cat name is "+name+st;

            return st;
        }
    }

}
