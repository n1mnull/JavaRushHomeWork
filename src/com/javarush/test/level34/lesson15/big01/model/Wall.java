package com.javarush.test.level34.lesson15.big01.model;

import java.awt.*;

/**
 * Created by Alenka on 12.06.2016.
 */
public class Wall extends CollisionObject {
    public Wall(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.drawRect(getX(),getY(),getWidth(),getHeight());
        graphics.setColor(Color.BLACK);
        graphics.fillRect(getX(),getY(),getWidth(),getHeight());
    }


}
