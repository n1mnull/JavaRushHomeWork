package com.javarush.test.level15.lesson12.home04;

/**
 * Created by Alenka on 23.05.2016.
 */
public class Earth implements Planet {
    private Earth() {}

    private static Earth instance;

    public synchronized static Earth getInstance() {
        if (instance == null)
            instance = new Earth();
        return instance;
    }
}
