package com.javarush.test.level20.lesson02.task05;

import java.io.*;

/* И еще раз о синхронизации
Разберитесь почему не работает метод main()
Реализуйте логику записи в файл и чтения из файла для класса Object
Метод load должен инициализировать объект данными из файла
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution
{
    public static void main(java.lang.String[] args)
    {
        try
        {
            File myFile = new File("y://200204.txt");
            OutputStream outputStream = new FileOutputStream(myFile);
            InputStream inputStream = new FileInputStream(myFile);

            Object object = new Object();
            object.string1 = new String();
            object.string2 = new String();
            object.save(outputStream);
            outputStream.flush();

            Object loadedObject = new Object();
            loadedObject.string1 = new String();
            loadedObject.string2 = new String();

            loadedObject.load(inputStream);

            object.string1.print();
            loadedObject.string1.print();
            object.string2.print();
            loadedObject.string2.print();

            outputStream.close();
            inputStream.close();

        }
        catch (IOException e)
        {
            e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }


    public static class Object
    {
        public String string1;
        public String string2;

        public void save(OutputStream outputStream) throws Exception
        {
            //implement this method - реализуйте этот метод
            PrintWriter printWriter = new PrintWriter(outputStream);
            java.lang.String hasString1 = this.string1 != null ? "yes" : "no";
            printWriter.println(hasString1);
            currentValue = countStrings - 1;
            java.lang.String hasString2 = this.string2 != null ? "yes" : "no";
            printWriter.println(hasString2);
            currentValue--;
            printWriter.close();
        }

        public void load(InputStream inputStream) throws Exception
        {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            int tmp = countStrings;
            countStrings = currentValue;
            java.lang.String hasString1 = reader.readLine();
            if (hasString1.equals("yes"))
            {
                this.string1 = new String();
            }
            java.lang.String hasString2 = reader.readLine();
            if (hasString2.equals("yes"))
            {
                this.string2 = new String();
            }
            countStrings = tmp;
            reader.close();
        }
    }

    public static int countStrings;
    public static int currentValue;

    public static class String
    {
        private final int number;

        public String()
        {
            number = ++countStrings;
        }

        public void print()
        {
            System.out.println("string #" + number);
        }
    }
}