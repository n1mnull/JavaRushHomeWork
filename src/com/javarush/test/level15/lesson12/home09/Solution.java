package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public static void main(String[] args) throws IOException
    {
//        String urlInput = "http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo&obj=3.14";
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String urlInput = bufferedReader.readLine();

        List<String> param = new LinkedList<String>();

        String strParam = urlInput.substring(urlInput.indexOf("?")+1,urlInput.length());

        int countParam = 0;
        String valueObj = "";

        while (true) {

            int equalSymbol = strParam.indexOf("=");
            int andSymbol = strParam.indexOf("&");

            if (andSymbol == -1){
                if (equalSymbol == -1) equalSymbol = strParam.length();
                param.add(strParam.substring(0, equalSymbol));

                if (param.get(countParam).equals("obj")) {
                    valueObj = strParam.substring(equalSymbol+1,strParam.length());
                }
                break;

            }

            if (equalSymbol > andSymbol) {
                param.add(strParam.substring(0, andSymbol));
            } else {
                param.add(strParam.substring(0, equalSymbol));
            }

            if (param.get(countParam).equals("obj")) {
                valueObj = strParam.substring(equalSymbol+1,andSymbol);
            }

            strParam = strParam.substring(andSymbol+1,strParam.length());
            countParam++;
        }

        for (String str : param)
        {
            System.out.print(str+" ");
        }


        if (!valueObj.equals("")) {
            System.out.println();
            try {
                alert(Double.parseDouble(valueObj));
            }
            catch (NumberFormatException e) {
                alert(valueObj);
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
