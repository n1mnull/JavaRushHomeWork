package com.javarush.test.level36.lesson04.home01;

import java.util.List;

/**
 * Created by Alenka on 07.06.2016.
 */
public class Controller {

    private static Model model = new Model();

    public List<String> onDataListShow() {
        return model.getStringDataList();
    }
}
