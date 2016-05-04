package com.javarush.test.level28.lesson15.big01;

import com.javarush.test.level28.lesson15.big01.model.Provider;

import java.util.Arrays;

/**
 * Created by Alenka on 30.04.2016.
 */
public class Controller
{
    private Provider[] providers;

    public Controller(Provider... providers)
    {
        if (providers == null) throw new IllegalArgumentException();
        if (providers.length == 0) throw new IllegalArgumentException();
        this.providers = providers;
    }

    @Override
    public String toString()
    {
        return "Controller{" +
                "providers=" + Arrays.toString(providers) +
                '}';
    }
}
