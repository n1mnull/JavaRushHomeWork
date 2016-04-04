package com.javarush.test.level20.lesson10.bonus01;

import java.util.ArrayList;

/* Алгоритмы-числа
Число S состоит из M чисел, например, S=370 и M(количество цифр)=3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
*/
public class Solution {
    public static int[] getNumbers(int N) {

        ArrayList<Integer> resultArrayList = new ArrayList<>();

        int summary = 0;
        int digit, temp;

        for (int i = 1; i < N; i++) {

            int length = (int)(Math.log10(i)+1);

            temp = i;
            summary = 0;

//            System.out.print(i + " длина " + length + " по цифрам ");

            for (int j = 0; j < length; j++) {

                digit = (int) temp / myPow(10,length-j-1);

                summary  = summary + myPow(digit,length);

                temp = temp - digit * myPow(10, length-j-1);

//                System.out.print(digit);

            }
//            System.out.println(" их сумма :" + summary);

            if (summary == i)  resultArrayList.add(i);

        }

        int[] result = new int[resultArrayList.size()];

        for (int i = 0; i < resultArrayList.size(); i++) result[i] = resultArrayList.get(i);

        return result;
    }

    public static int myPow(int n, int pow) {
        int answer = 1;
        for (int i = 0; i < pow; i++){
            answer *= n;
        }
        return answer;

    }

//    public static void main(String[] args)
//    {
//        int[] aaa = getNumbers(100000);
//
//        for (int i = 0; i < aaa.length; i++)
//        {
//            System.out.println(aaa[i]);
//        }
//
//    }

}
