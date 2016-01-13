package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

import javax.sound.midi.Soundbank;

public class Solution
{
    public static void main(String[] args)
    {
        Human dedushka1 = new Human("Дедушка1",true,77,null,null);
        Human dedushka2 = new Human("Дедушка2",true,70,null,null);
        Human babushka1 = new Human("Бабушка1",false,73,null,null);
        Human babushka2 = new Human("Бабушка2",false,71,null,null);

        Human papa = new Human("Papa",true,41,dedushka1,babushka1);
        Human mama = new Human("Mama",false,44,dedushka2,babushka2);

        Human deti1 = new Human("Deti1",true,16,papa,mama);
        Human deti2 = new Human("Deti2",true,13,papa,mama);
        Human deti3 = new Human("Deti3",false,10,papa,mama);

        System.out.println(dedushka1);
        System.out.println(dedushka2);
        System.out.println(babushka1);
        System.out.println(babushka2);

        System.out.println(papa);
        System.out.println(mama);

        System.out.println(deti1);
        System.out.println(deti2);
        System.out.println(deti3);

    }

    public static class Human
    {
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        public Human(String name, boolean sex, int age, Human father, Human mother){
            this.name=name;
            this.sex=sex;
            this.age=age;
            this.father=father;
            this.mother=mother;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
