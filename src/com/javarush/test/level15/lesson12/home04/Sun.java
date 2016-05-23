package com.javarush.test.level15.lesson12.home04;

/**
 * Created by Alenka on 23.05.2016.
 */
public class Sun implements Planet {

    private Sun() {}

    private static Sun instance;

    public synchronized static Sun getInstance() {
        if (instance == null)
            instance = new Sun();
        return instance;
    }
}
