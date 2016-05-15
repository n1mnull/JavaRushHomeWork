package com.javarush.test.level32.lesson15.big01;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Alenka on 15.05.2016.
 */
public class View extends JFrame implements ActionListener {

    private Controller controller;

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void init() {

    }

    public void exit() {
        controller.exit();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {

    }
}
