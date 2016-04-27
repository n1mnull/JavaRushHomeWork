package com.javarush.test.level29.lesson09.task01;

import java.math.BigDecimal;

/* Этот странный BigDecimal
Исправьте ошибку реализации, приводящую к погрешности вычисления, в методе getValue.
Сигнатуру метода не менять. Округление не использовать.
Читайте доп. статью про особенности автобоксинга.
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getValue(1.1d, 1.2d));
    }

    public static BigDecimal getValue(double v1, double v2) {
        BigDecimal answer = BigDecimal.valueOf(v1).add(BigDecimal.valueOf(v2));
        return answer;
//        BigDecimal bigDecimal1 = BigDecimal.valueOf(v1);
//        System.out.println(bigDecimal1);
//        BigDecimal bigDecimal2 = BigDecimal.valueOf(v2);
//        System.out.println(bigDecimal2);
//        BigDecimal bigDecimal3 = bigDecimal1.add(bigDecimal2);
//        System.out.println(bigDecimal3);
//        return new BigDecimal(v1).add(new BigDecimal(v2));
    }
}
