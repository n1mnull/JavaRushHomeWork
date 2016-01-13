package com.javarush.test.level14.lesson06.home01;

public class BelarusianHen extends Hen
{
    private int belarusEggCount = 20;

    @Override
    public int getCountOfEggsPerMonth()
    {
        return belarusEggCount;
    }

    String getDescription(){

        String descriptionExtends = super.getDescription();
        return  descriptionExtends + " Моя страна - Belarus. Я несу " + belarusEggCount +" яиц в месяц.";

    }
}
