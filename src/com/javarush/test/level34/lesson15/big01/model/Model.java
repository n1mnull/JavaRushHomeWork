package com.javarush.test.level34.lesson15.big01.model;

import com.javarush.test.level34.lesson15.big01.controller.EventListener;

import java.nio.file.Paths;

/**
 * Created by Alenka on 09.06.2016.
 */
public class Model {

    public static final int FIELD_SELL_SIZE = 20;
    private EventListener eventListener;
    private GameObjects gameObjects;
    private int currentLevel = 1;
    private LevelLoader levelLoader = new LevelLoader(Paths.get("Y:\\JavaRushHomeWork\\src\\com\\javarush\\test\\level34\\lesson15\\big01\\res\\levels.txt"));

    public void setEventListener(EventListener eventListener) {

        this.eventListener = eventListener;
    }

    public GameObjects getGameObjects() {

        return gameObjects;
    }

    public void restartLevel(int level) {

        gameObjects = levelLoader.getLevel(level);
    }

    public void restart() {

        restartLevel(currentLevel);
    }

    public void startNextLevel() {

        restartLevel(++currentLevel);
    }


}
