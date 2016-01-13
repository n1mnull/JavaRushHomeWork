package com.javarush.test.level14.lesson06.home01;

public class UkrainianHen extends Hen
{
    private int ukraineEggCount = 100;

    @Override
    public int getCountOfEggsPerMonth()
    {
        return ukraineEggCount;
    }

    String getDescription(){

        String descriptionExtends = super.getDescription();
        return  descriptionExtends + " Моя страна - Ukraine. Я несу " + ukraineEggCount +" яиц в месяц.";

    }
}

//         <getDescription() родительского класса>  + <" Моя страна - Sssss. Я несу N яиц в месяц.">
//        где Sssss - название страны
//        где N - количество яиц в месяц