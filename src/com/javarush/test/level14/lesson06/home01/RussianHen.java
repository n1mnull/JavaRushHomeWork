package com.javarush.test.level14.lesson06.home01;

public class RussianHen extends Hen
{
    private int russianEggCount = 1;

    @Override
    public int getCountOfEggsPerMonth()
    {
        return russianEggCount;
    }
    String getDescription(){

        String descriptionExtends = super.getDescription();
        return  descriptionExtends + " Моя страна - Russia. Я несу " + russianEggCount +" яиц в месяц.";

    }

}
