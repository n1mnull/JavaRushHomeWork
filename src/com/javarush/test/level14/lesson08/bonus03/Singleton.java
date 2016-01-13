package com.javarush.test.level14.lesson08.bonus03;

public class Singleton
{
    private static Singleton singleton;

    private Singleton()
    {
    }

    static Singleton getInstance()
    {

        if (singleton == null) {

            return singleton = new Singleton();

        } else {

            return singleton;

        }
    }
}
