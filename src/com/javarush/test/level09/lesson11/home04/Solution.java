package com.javarush.test.level09.lesson11.home04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* Конвертер дат
Ввести с клавиатуры дату в формате «08/18/2013»
Вывести на экран эту дату в виде «AUG 18, 2013».
Воспользоваться объектом Date и SimpleDateFormat.
*/

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String inputString = reader.readLine();

        Date inputDate = new Date(inputString);

        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);

        System.out.println(dateFormat.format(new Date(inputString)).toString().toUpperCase());


//        for (int i = 0; i < 30; i++)
//        {
//            String str ="15/"+i+"/1990";
//            Date testDate = new Date(str);
//            System.out.print(testDate+" : ");
//            SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
//            System.out.println(dateFormat.format(testDate));
//
//        }





    }
}
