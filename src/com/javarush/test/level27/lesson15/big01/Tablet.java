package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Order;

import java.io.IOException;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Alenka on 22.04.2016.
 */
public class Tablet extends Observable
{
    final int number;
    private final static java.util.logging.Logger logger = Logger.getLogger(Tablet.class.getName());

    public Tablet(int number)
    {
        this.number = number;
    }

    public void createOrder() throws IOException
    {
        try
        {
            final Order order = new Order(this);
            if (!order.isEmpty())
            {
                ConsoleHelper.writeMessage(order.toString());
                setChanged();
                notifyObservers(order);
            }


        }
        catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }

    }

    @Override
    public String toString()
    {
        return "Tablet{" +
                "number=" + number +
                '}';
    }
}
