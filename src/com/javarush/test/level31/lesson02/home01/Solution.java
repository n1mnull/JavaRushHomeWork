package com.javarush.test.level31.lesson02.home01;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* Проход по дереву файлов
1. На вход метода main подаются два параметра.
Первый - path - путь к директории, второй - resultFileAbsolutePath - имя файла, который будет содержать результат.
2. Для каждого файла в директории path и в ее всех вложенных поддиректориях выполнить следующее:
2.1. Если у файла длина в байтах больше 50, то удалить его.
2.2. Если у файла длина в байтах НЕ больше 50, то для всех таких файлов:
2.2.1. отсортировать их по имени файла в возрастающем порядке, путь не учитывать при сортировке
2.2.2. переименовать resultFileAbsolutePath в 'allFilesContent.txt'
2.2.3. в allFilesContent.txt последовательно записать содержимое всех файлов из п. 2.2.1. Тела файлов разделять "\n"
2.3. Удалить директории без файлов (пустые).
Все файлы имеют расширение txt.
*/
public class Solution {

    public static void main(String[] args) {
        File path = new File(args[0]);
        File resultFileAbsolutePath = new File(args[1]);

        File renamedFile = new File(resultFileAbsolutePath.getParent()+"/allFilesContent.txt");
        resultFileAbsolutePath.renameTo(renamedFile);

        List<File> filesQueue = new ArrayList<>();
        List<File> resultFilesList = new ArrayList<>();

        Collections.addAll(filesQueue, path.listFiles());

        for (int i = 0; i < filesQueue.size(); i++)
        {
            File tmpFile = filesQueue.get(i);

            if (tmpFile.isDirectory())
            {
                Collections.addAll(filesQueue,tmpFile.listFiles());
            }
            else
            {
                if (tmpFile.length()>50 && !tmpFile.equals(renamedFile))
                {
                    File tmpParent = tmpFile.getParentFile();
                    tmpFile.delete();
                    if (tmpParent.isDirectory() && tmpParent.length() == 0)
                        tmpParent.delete();
                }
                else
                {
                    resultFilesList.add(tmpFile);
                }
            }
        }

        Collections.sort(resultFilesList, new Comparator<File>()
        {
            @Override
            public int compare(File o1, File o2)
            {
                return o1.getName().compareTo(o2.getName());
            }
        });

        try
        {
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(renamedFile));
            for (File file : resultFilesList)
            {
                BufferedReader fileReader = new BufferedReader(new FileReader(file));
                String line;
                while ((line=fileReader.readLine()) != null)
                {
                    fileWriter.write(line);
                    fileWriter.write("\n");
                }
                fileReader.close();
            }
            fileWriter.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}