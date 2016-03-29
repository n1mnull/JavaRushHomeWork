package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.*;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException, InterruptedException
    {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> fileNameList = new ArrayList<>();

        String tempString;

        while (!(tempString = bufferedReader.readLine()).equals("exit")) {

            fileNameList.add(tempString);
        }
        bufferedReader.close();

        for (int i = 0; i < fileNameList.size(); i++) {
            ReadThread readThread = new ReadThread(fileNameList.get(i));
            readThread.run();
            readThread.join();
        }

        System.out.println(resultMap);

    }

    public static class ReadThread extends Thread {
        private String fileName;

        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }

        public void run() {
            try {

                FileInputStream fileInputStream = new FileInputStream(fileName);
                ArrayList<Integer> listInteger = new ArrayList<>();
                while (fileInputStream.available() > 0) {
                    listInteger.add(fileInputStream.read());
                }
                fileInputStream.close();

                int count;
                int idMax = 0;
                int maxCount = 0;

                for (int i = 0; i < listInteger.size(); i++) {
                    count = Collections.frequency(listInteger,listInteger.get(i));
                    if (count > maxCount) {
                        maxCount = count;
                        idMax = listInteger.get(i);
                    }
                }
                resultMap.put(fileName,idMax);

            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        // implement file reading here - реализуйте чтение из файла тут
    }
}
