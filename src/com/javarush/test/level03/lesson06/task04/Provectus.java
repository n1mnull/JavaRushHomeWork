package com.javarush.test.level03.lesson06.task04;

/**
 * Created by Alenka on 31.05.2016.
 */
public class Provectus {

    public static void main(String[] args) {

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 1; i < 100; i++) {

            if (i % 3 == 0) {
                stringBuilder.append("Fizz");
            }
            if (i % 5 == 0) {
                stringBuilder.append("Buzz");
            }
            if (stringBuilder.length() == 0) {
                stringBuilder.append(i);
            }

            System.out.println(stringBuilder);
            stringBuilder.delete(0,stringBuilder.length());

        }
    }
}
