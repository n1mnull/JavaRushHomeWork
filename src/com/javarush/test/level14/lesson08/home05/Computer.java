package com.javarush.test.level14.lesson08.home05;

import com.javarush.test.level14.lesson08.home05.Keyboard;
import com.javarush.test.level14.lesson08.home05.Monitor;
import com.javarush.test.level14.lesson08.home05.Mouse;

public class Computer {
    private Keyboard keyboard = new Keyboard();
    private Mouse mouse = new Mouse();
    private Monitor monitor = new Monitor();

    public Keyboard getKeyboard() {
        return this.keyboard;
    }

    public Mouse getMouse() {
        return this.mouse;
    }

    public Monitor getMonitor() {
        return this.monitor;
    }

    public Computer() {
    }
}