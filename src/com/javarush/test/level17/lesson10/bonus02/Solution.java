package com.javarush.test.level17.lesson10.bonus02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    static int id;
    static String name;
    static String sexString;
    static String bdString;

    static SimpleDateFormat simpleDateFormatInput = new SimpleDateFormat("dd/MM/yyyy");
    static SimpleDateFormat simpleDateFormatOutput = new SimpleDateFormat("dd-MMM-YYYY", Locale.ENGLISH);

    public static void main(String[] args) throws ParseException
    {
        //start here - начни тут
        String parameter = args[0];

        switch (parameter)
        {
            case "-i":
                for (int i = 1; i < args.length; i++) {
                    id = Integer.parseInt(args[i]);
                    infoPerson(id);
                }
                break;

            case "-d":
                for (int i = 1; i < args.length; i++) {
                    id = Integer.parseInt(args[i]);
                    logicalDelete(id);
                }
                break;

            case "-c":
                for (int i = 1; i < args.length; i=i+3)
                {
                    name = args[i];
                    sexString = args[i+1];
                    bdString = args[i+2];
                    createPerson(name,sexString,bdString);
                }

                break;

            case "-u":
                for (int i = 1; i < args.length; i=i+4)
                {
                    id = Integer.parseInt(args[i]);
                    name = args[i+1];
                    sexString = args[i+2];
                    bdString = args[i+3];
                    updatePerson(id, name, sexString, bdString);
                }
                break;
        }
    }

    private static void updatePerson(int id, String name, String sexString, String bdString) throws ParseException
    {
        Date bd = simpleDateFormatInput.parse(bdString);
        allPeople.get(id).setName(name);
        allPeople.get(id).setSex((sexString.equals("м"))? Sex.MALE : Sex.FEMALE);
        allPeople.get(id).setBirthDay(bd);
    }

    private static void createPerson(String name, String sexString, String bdString) throws ParseException
    {
        Date bd = simpleDateFormatInput.parse(bdString);
        if (sexString.equals("м")) allPeople.add(Person.createMale(name,bd));
        else allPeople.add(Person.createFemale(name,bd));
        System.out.println(allPeople.size()-1);

    }

    private static void logicalDelete(int id)
    {
        allPeople.get(id).setBirthDay(null);
        allPeople.get(id).setName(null);
        allPeople.get(id).setSex(null);
    }

    private static void infoPerson(int id) {
        name = allPeople.get(id).getName();
        sexString = (allPeople.get(id).getSex() == Sex.MALE) ? "м" : "ж";
        Date bd = allPeople.get(id).getBirthDay();
        System.out.println(name + " " + sexString + " " + simpleDateFormatOutput.format(bd));
    }
}
