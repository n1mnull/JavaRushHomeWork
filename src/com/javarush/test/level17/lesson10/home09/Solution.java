package com.javarush.test.level17.lesson10.home09;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* Транзакционность
Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла
2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки, которые есть в forRemoveLines
4. Если список allLines НЕ содержит каких-либо строк, которые есть в forRemoveLines, то
4.1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Метод joinData должен вызываться в main. Все исключения обработайте в методе main.
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {

        try {

            BufferedReader nameReader = new BufferedReader(new InputStreamReader(System.in));

            String fileName1, fileName2;
            String tempStr;
            fileName1 = nameReader.readLine();
            fileName2 = nameReader.readLine();
            nameReader.close();


            Scanner scanner1 = new Scanner (new File(fileName1));
            Scanner scanner2 = new Scanner (new File(fileName2));

//            BufferedReader fileReader1 = new BufferedReader(new FileReader(fileName1));
//            BufferedReader fileReader2 = new BufferedReader(new FileReader(fileName2));
//            while ((tempStr=fileReader1.readLine()) != null) {
//                allLines.add(tempStr);
//            }
//            while ((tempStr=fileReader2.readLine()) != null) {
//                forRemoveLines.add(tempStr);
//            }
//            fileReader1.close();
//            fileReader2.close();
//            absentString6

            while (scanner1.hasNextLine()) {
                allLines.add(scanner1.nextLine()); }
            scanner1.close();

            while (scanner2.hasNextLine()) {
                forRemoveLines.add(scanner2.nextLine()); }
            scanner2.close();

            new Solution().joinData();

        } catch (IOException e) {
        }

    }

    public void joinData () throws CorruptedDataException {

//        int countMatches = 0;
//
//        for (int i = 0; i < allLines.size(); i++) {
//            for (int j = 0; j < forRemoveLines.size(); j++) {
//                if (allLines.get(i).equals(forRemoveLines.get(j))) {
//                    countMatches++;
//                    break;
//                }
//            }
//        }
//
//        if (countMatches == forRemoveLines.size()) {
//            for (int i = 0; i < allLines.size(); i++) {
//                for (int j = 0; j < forRemoveLines.size(); j++) {
//                    if (allLines.get(i).equals(forRemoveLines.get(j))) {
//                        allLines.remove(i);
//                    }
//                }
//            }

        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
