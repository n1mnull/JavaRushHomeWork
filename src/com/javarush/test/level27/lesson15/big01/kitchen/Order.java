package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.Tablet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alenka on 22.04.2016.
 */
public class Order
{
    List<Dish> dishes;
    Tablet tablet;

    public Order(Tablet tablet) throws IOException
    {
        this.tablet = tablet;
        dishes = ConsoleHelper.getAllDishesForOrder();
    }

    @Override
    public String toString() {
        if (dishes.isEmpty()) return "";

        String listDishesOrdered = String.format("Your order: %s of %s", dishes, tablet.toString());
        return listDishesOrdered;
    }


    public int getTotalCookingTime(){
        int time = 0;
        for(Dish dish: dishes){
            time = time + dish.getDuration();
        }
        return time;
    }

    public boolean isEmpty(){
        if(dishes.isEmpty()){
            return true;
        }
        else return false;
    }
}
