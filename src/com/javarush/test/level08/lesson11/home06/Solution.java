package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{

    public static void main(String[] args)
    {
        ArrayList<Human> children = new ArrayList<Human>();
        ArrayList<Human> parents1 = new ArrayList<Human>();
        ArrayList<Human> parents2 = new ArrayList<Human>();

        Human children1 = new Human("Children1",true,12,new ArrayList<Human>());
        Human children2 = new Human("Children2",false,10,new ArrayList<Human>());
        Human children3 = new Human("Children3",true,10,new ArrayList<Human>());
        children.add(children1);
        children.add(children2);
        children.add(children3);

        Human father = new Human("Papa",true,33,children);
        Human mother = new Human("Mama",false,30,children);
        parents1.add(father);
        parents2.add(mother);

        Human grandPa1 = new Human("Dedushka1",true,55,parents1);
        Human grandMa1 = new Human("Babushka1",false,56,parents1);

        Human grandPa2 = new Human("Dedushka2",true,52,parents2);
        Human grandMa2 = new Human("Babushka2",false,50,parents2);

        System.out.println(grandMa1);
        System.out.println(grandPa1);
        System.out.println(grandMa2);
        System.out.println(grandPa2);

        System.out.println(father);
        System.out.println(mother);

        System.out.println(children1);
        System.out.println(children2);
        System.out.println(children3);
    }

    public static class Human
    {
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children = new ArrayList<Human>();

        public Human(String name, boolean sex, int age, ArrayList<Human> children)
        {
            this.name=name;
            this.sex=sex;
            this.age=age;
            this.children=children;
        }


        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }
            return text;
        }
    }
}
