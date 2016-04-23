package com.javarush.test.level27.lesson15.big01.kitchen;

/**
 * Created by Alenka on 22.04.2016.
 */
public enum Dish
{
    Fish(25), Steak(30), Soup(15), Juice(5), Water(3);

    private int duration;

    Dish(int i)
    {
        duration = i;
    }

    public int getDuration()
    {
        return duration;
    }

    public static String allDishesToString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Dish dish : Dish.values()) {
            stringBuilder.append(dish);
            stringBuilder.append(", ");
        }
        stringBuilder.delete(stringBuilder.length()-2,stringBuilder.length());
        return stringBuilder.toString();
    }
}