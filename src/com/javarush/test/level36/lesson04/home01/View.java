package com.javarush.test.level36.lesson04.home01;

/**
 * Created by Alenka on 07.06.2016.
 */
public class View {

    private static Controller controller = new Controller();

    public void fireEventShowData() {
        System.out.println(controller.onDataListShow());
    }
}
