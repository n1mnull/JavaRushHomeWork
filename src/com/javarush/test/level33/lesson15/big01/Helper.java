package com.javarush.test.level33.lesson15.big01;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Created by Alenka on 26.05.2016.
 */
public class Helper {

    public static String generateRandomString() {
        SecureRandom random = new SecureRandom();
        return new BigInteger(57, random).toString(32);
    }


    public static void printMessage(String message) {
        System.out.println(message);
    }
}
