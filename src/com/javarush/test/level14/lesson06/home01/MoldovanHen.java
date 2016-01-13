package com.javarush.test.level14.lesson06.home01;

public class MoldovanHen extends Hen
{
    private int moldovaEggCount = 10;

    @Override
    public int getCountOfEggsPerMonth()
    {
        return moldovaEggCount;
    }

    String getDescription(){

        String descriptionExtends = super.getDescription();
        return  descriptionExtends + " Моя страна - Moldova. Я несу " + moldovaEggCount +" яиц в месяц.";

    }
}
