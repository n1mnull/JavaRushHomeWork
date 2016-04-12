package com.javarush.test.level25.lesson05.task01;

/* Switch для нитей
Обработайте список нитей в зависимости от состояния:
1. Если нить еще не запущена, то запустите ее.
2. Если нить в ожидании, то прервите ее.
3. Если нить работает, то проверить маркер isInterrupted.
4. Если нить прекратила работу, то выведите в консоль ее приоритет.
Используйте switch.
*/
public class Solution {
    public static void processThreads(Thread... threads) {
        //implement this method - реализуйте этот метод

        for (Thread choiceThread : threads) {
            switch (choiceThread.getState()) {
                case NEW:
                    choiceThread.start();
                    break;
                case RUNNABLE:
                    choiceThread.isInterrupted();
                    break;
                case BLOCKED:
                    choiceThread.interrupt();
                    break;
                case WAITING:
                    choiceThread.interrupt();
                    break;
                case TIMED_WAITING:
                    choiceThread.interrupt();
                    break;
                case TERMINATED:
                    System.out.println(choiceThread.getPriority());
                    break;
            }
        }
    }
}
