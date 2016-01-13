package com.javarush.test.level04.lesson10.task04;

import java.io.*;

/* S-квадрат
Вывести на экран квадрат из 10х10 букв S используя цикл while.
Буквы в каждой строке не разделять.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int osX = 10;
        int osY = 10;

        while (osX >= 1){
            while (osY >=1){
                System.out.print("S");
                osY--;
            }
            System.out.println("");
            osY=10;
            osX--;
        }


    }
}
