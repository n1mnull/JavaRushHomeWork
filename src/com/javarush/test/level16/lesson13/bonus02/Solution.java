package com.javarush.test.level16.lesson13.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Клубок
1. Создай 5 различных своих нитей c отличным от Thread типом:
1.1. нить 1 должна бесконечно выполняться;
1.2. нить 2 должна выводить "InterruptedException" при возникновении исключения InterruptedException;
1.3. нить 3 должна каждые полсекунды выводить "Ура";
1.4. нить 4 должна реализовать интерфейс Message, при вызове метода showWarning нить должна останавливаться;
1.5. нить 5 должна читать с консоли цифры пока не введено слово "N", а потом вывести в консоль сумму введенных цифр.
2. В статическом блоке добавь свои нити в List<Thread> threads в перечисленном порядке.
3. Нити не должны стартовать автоматически.
Подсказка: Нить 4 можно проверить методом isAlive()
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<Thread>(5);

    static {
        threads.add(new ThreadClass1());
        threads.add(new ThreadClass2());
        threads.add(new ThreadClass3());
        threads.add(new ThreadClass4());
        threads.add(new ThreadClass5());
    }

    public static class ThreadClass1 extends Thread {

        public void run() {
            while (true){
            }
        }
    }

    public static class ThreadClass2 extends Thread {

        public void run() {
            try {
                while (!isInterrupted()) {}
                throw new InterruptedException();
            } catch (InterruptedException e){
                System.out.println("InterruptedException");
            }
        }
    }

    public static class ThreadClass3 extends Thread {

        public void run() {
            while (true) {
                System.out.println("Ура");
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class ThreadClass4 extends Thread implements Message {

        @Override
        public void showWarning() {
            this.interrupt();
            try {
                this.join();
            } catch (InterruptedException e) {}
        }
        public void run(){
            while (!isInterrupted()) {}
        }
    }

    public static class ThreadClass5 extends Thread {

        public void run() {
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
            String tempString;
            int summary = 0;
            try {
                while (!(tempString=buffer.readLine()).equals("N")){
                summary = summary  + Integer.parseInt(tempString);
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(summary);
        }
    }
}
