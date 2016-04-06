package com.javarush.test.level22.lesson05.task01;

import java.util.ArrayList;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
Метод main не участвует в тестировании.
*/
public class Solution {

    public static String getPartOfString(String string) throws TooShortStringException
    {

        if (string == null || string.isEmpty()) {throw new TooShortStringException();}

        String result = "";
        String[] arrayWord = string.split(" ");


//        for (int i = 0; i < arrayWord.length; i++) {
//            System.out.println(i + ": " + arrayWord[i]);
//        }

        if (arrayWord.length < 5) {
            throw new TooShortStringException();
        }

        for (int i = 1; i < 5; i++) {

            result += arrayWord[i] + " ";
        }

        return result.substring(0,result.length()-1);
    }

    public static class TooShortStringException extends Exception{
    }

    public static void main(String[] args) throws TooShortStringException
    {
//        String s = getPartOfString("    JavaRush-лучшийсервисобученияJava.Ятаксчитаю!");
        String s = getPartOfString(" JavaRush-лучший сервис обучения Java. Ятаксчитаю!");
        System.out.println("@" + s + "@");
    }
}
