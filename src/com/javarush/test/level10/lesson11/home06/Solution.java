package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        String firstname;
        String lastname;
        boolean sex;
        int age;
        int height;
        String cityBirth;

        public Human(String firstname,String lastname,boolean sex, int age,int height,String cityBirth)
        {
            this.firstname=firstname;
            this.lastname=lastname;
            this.sex=sex;
            this.age=age;
            this.height=height;
            this.cityBirth=cityBirth;
        }

        public Human(String firstname,String lastname)
        {
            this.firstname=firstname;
            this.lastname=lastname;
        }

        public Human(String firstname,String lastname,boolean sex)
        {
            this.firstname=firstname;
            this.lastname=lastname;
            this.sex=sex;
        }
        public Human(String firstname)
        {
            this.firstname=firstname;
        }
        public Human(boolean sex, int age)
        {
            this.sex=sex;
            this.age=age;
        }
        public Human(int age,int height,String cityBirth)
        {
            this.age=age;
            this.height=height;
            this.cityBirth=cityBirth;
        }
        public Human(int age,String cityBirth)
        {
            this.cityBirth=cityBirth;
        }
        public Human(int age,int height)
        {
            this.age=age;
            this.height=height;
        }
        public Human(boolean sex)
        {
            this.sex=sex;
        }
        public Human(String lastname,boolean sex, int age)
        {
            this.lastname=lastname;
            this.sex=sex;
            this.age=age;
        }

    }
}
