package com.javarush.test.level17.lesson10.bonus01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    static String name;
    static int id;
    static Sex sex;
    static String bdString;

    public static void main(String[] args) throws ParseException
    {

        String parametr = args[0];
        String sexString;

        switch (parametr) {
            case "-i":
                id = Integer.parseInt(args[1]);
                infoPerson(id);
                break;
            case "-d":
                id = Integer.parseInt(args[1]);
                logicalDelete(id);
                break;
            case "-c":
                name = args[1];
                sexString = args[2];
                bdString = args[3];
                createPerson(name,sexString,bdString);
                break;
            case "-u":
                id = Integer.parseInt(args[1]);
                name = args[2];
                sexString = args[3];
                bdString = args[4];
                updatePerson(id, name, sexString, bdString);
                break;
        }
    }

    private static void updatePerson(int id, String name, String sexString, String bdString) throws ParseException
    {
        SimpleDateFormat simpleDateFormatInput = new SimpleDateFormat("dd/MM/yyyy");
        Date bd = simpleDateFormatInput.parse(bdString);

        allPeople.get(id).setName(name);
        allPeople.get(id).setSex((sexString.equals("м"))? Sex.MALE : Sex.FEMALE);
        allPeople.get(id).setBirthDay(bd);

    }

    private static void createPerson(String name, String sexString, String bdString) throws ParseException
    {
        SimpleDateFormat simpleDateFormatInput = new SimpleDateFormat("dd/MM/yyyy");
        Date bd = simpleDateFormatInput.parse(bdString);

        if (sexString.equals("м")) allPeople.add(Person.createMale(name,bd));
        else allPeople.add(Person.createFemale(name,bd));
        System.out.println(allPeople.size()-1);
    }

    private static void logicalDelete(int id)
    {
        allPeople.get(id).setBirthDay(null);
    }

    private static void infoPerson(int id) {
        name = allPeople.get(id).getName();

        sex = allPeople.get(id).getSex();
        String sexString;
        if (sex == Sex.MALE) sexString = "м";
        else sexString = "ж";

        Date bd = allPeople.get(id).getBirthDay();
        SimpleDateFormat simpleDateFormatOutput = new SimpleDateFormat("dd-MMM-YYYY", Locale.ENGLISH);
        System.out.println(allPeople.get(id).getName() + " "+ sexString + " " + simpleDateFormatOutput.format(bd));
    }

}
