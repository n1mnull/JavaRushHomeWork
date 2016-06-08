package com.javarush.test.level37.lesson04.big01;

import com.javarush.test.level37.lesson04.big01.female.FemaleFactory;
import com.javarush.test.level37.lesson04.big01.male.MaleFactory;

/**
 * Created by Alenka on 08.06.2016.
 */
public class FactoryProducer {

    public static enum HumanFactoryType {
        MALE, FEMALE
    }

    public static AbstractFactory getFactory(HumanFactoryType humanType) {

        if (humanType.equals(HumanFactoryType.FEMALE)) return new FemaleFactory();

        else if (humanType.equals(HumanFactoryType.MALE)) return new MaleFactory();

        else return null;
    }

}
