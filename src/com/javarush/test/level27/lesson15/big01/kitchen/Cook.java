package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;

import java.util.Observable;
import java.util.Observer;

public class Cook extends Observable implements Observer
{
    String name;

    public Cook(String name) {
        this.name = name;
    }

    public void update(Observable observable, Object arg) {
        ConsoleHelper.writeMessage("Start cooking - " + arg + ", cooking time " + ((Order) arg).getTotalCookingTime() + "min");
        super.setChanged();
        notifyObservers(arg);

    }

    @Override
    public String toString()
    {
        return name;
    }
}