package com.javarush.test.level07.lesson09.task04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Буква «р» и буква «л»
1. Создай список слов, заполни его самостоятельно.
2. Метод fix должен:
2.1. удалять из списка строк все слова, содержащие букву «р»
2.2. удваивать все слова содержащие букву «л».
2.3. если слово содержит и букву «р» и букву «л», то оставить это слово без изменений.
2.4. с другими словами ничего не делать.
Пример:
роза
лира
лоза
Выходные данные:
лира
лоза
лоза
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
       // BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> listString = new ArrayList<String>();

        listString.add("роза"); //0
        listString.add("лира"); //1
        listString.add("лоза"); //2
        /*listString.add("лобовь"); //2
        listString.add("марка"); //2
        listString.add("снег"); //2
        */
        listString = fix(listString);

        for (String s : listString)
        {
            System.out.println(s);
        }
    }

    public static ArrayList<String> fix(ArrayList<String> listString)
    {
        ArrayList<String> fixedListString = new ArrayList<String>();

        for (int i=0;i<listString.size();i++){
            if (!listString.get(i).contains("р") && listString.get(i).contains("л")){
                fixedListString.add(listString.get(i));
                fixedListString.add(listString.get(i));
            }
            if (listString.get(i).contains("р") && listString.get(i).contains("л")){
                fixedListString.add(listString.get(i));
            }
            if (!listString.get(i).contains("р") && !listString.get(i).contains("л")){
                fixedListString.add(listString.get(i));
            }
        }
        return fixedListString;
    }
}