package com.javarush.test.level20.lesson02.task02;

import javax.jws.soap.SOAPBinding;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();

            User n1mnull = new User();
            n1mnull.setFirstName("Ivan");
            n1mnull.setLastName("Poddubny");
            n1mnull.setBirthDate(new Date(1984,8,21));
            n1mnull.setCountry(User.Country.UKRAINE);
            n1mnull.setMale(true);

            User mindalyona = new User();
            mindalyona.setFirstName("Alena");
            mindalyona.setLastName("Poddubna");
            mindalyona.setBirthDate(new Date(1985,9,22));
            mindalyona.setCountry(User.Country.UKRAINE);
            mindalyona.setMale(false);

            User starbucks = new User();
            starbucks.setFirstName("Starbucks");
            starbucks.setBirthDate(new Date(2014,11,22));
            starbucks.setCountry(User.Country.OTHER);

            javaRush.users.add(n1mnull);
            javaRush.users.add(mindalyona);
            javaRush.users.add(starbucks);

            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);

            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.println("@");
            if (this.users.size() > 0) {
                for (User current : this.users) {
                    StringBuilder sb = new StringBuilder();
                    String hasFirstName = (current.getFirstName() != null) ? "yes" : "no";
                    if ("yes".equals(hasFirstName))
                        sb.append(current.getFirstName()).append(" ");
                    else
                        sb.append("- ");

                    String hasLastName = (current.getLastName() != null) ? "yes" : "no";
                    if ("yes".equals(hasLastName))
                        sb.append(current.getLastName()).append(" ");
                    else
                        sb.append("- ");

                    String hasBirthDate = (current.getBirthDate() != null) ? "yes" : "no";
                    if ("yes".equals(hasBirthDate))
                        sb.append(current.getBirthDate().getYear()).append(" ").append(current.getBirthDate().getMonth()).append(" ").append(current.getBirthDate().getDate()).append(" ");
                    else
                        sb.append("- - - ");

                    if (current.isMale())
                        sb.append(true).append(" ");
                    else
                        sb.append(false).append(" ");

                    String hasCountry = (current.getCountry() != null) ? "yes" : "no";
                    if ("yes".equals(hasCountry))
                        sb.append(current.getCountry().getDisplayedName()).append(" ");
                    else
                        sb.append("- ");
                    printWriter.println(sb.toString());
                }
            }
            printWriter.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line = reader.readLine();
            if (line.equals("@"))
                line = reader.readLine();
            while (line != null) {
                User user = new User();
                String[] lineArray = line.split(" ");
                if (!"-".equals(lineArray[0]))
                    user.setFirstName(lineArray[0]);
                if (!"-".equals(lineArray[1]))
                    user.setLastName(lineArray[1]);
                if (!"-".equals(lineArray[2]))
                    user.setBirthDate(new Date(Integer.parseInt(lineArray[2]), Integer.parseInt(lineArray[3]), Integer.parseInt(lineArray[4])));
                user.setMale(Boolean.parseBoolean(lineArray[5]));
                if (!"-".equals(lineArray[6]))
                {
                    User.Country country;
                    switch (lineArray[6])
                    {
                        case "Ukraine":
                            country = User.Country.UKRAINE;
                            break;
                        case "Russia":
                            country = User.Country.RUSSIA;
                            break;
                        default:
                            country = User.Country.OTHER;
                            break;
                    }
                    user.setCountry(country);
                }
                this.users.add(user);
                line = reader.readLine();
                if ("@".equals(line))
                    break;
            }
            reader.close();
        }
    }
}
