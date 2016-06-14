package com.javarush.test.level34.lesson15.big01.model;

import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

import static com.javarush.test.level34.lesson15.big01.model.Model.FIELD_SELL_SIZE;

/**
 * Created by Alenka on 13.06.2016.
 */
public class LevelLoader {

    private Path levels;

    public LevelLoader(Path levels) {
        this.levels = levels;
    }

    public GameObjects getLevel(int level) {

        Set<Box> boxes = new HashSet<>();
        Set<Wall> walls = new HashSet<>();
        Set<Home> homes = new HashSet<>();
        Player player = null;

        player = new Player(FIELD_SELL_SIZE/2, FIELD_SELL_SIZE/2);
        homes.add(new Home(FIELD_SELL_SIZE/2, FIELD_SELL_SIZE/2));
        boxes.add(new Box(FIELD_SELL_SIZE/2, FIELD_SELL_SIZE/2));
        walls.add(new Wall(FIELD_SELL_SIZE/2, FIELD_SELL_SIZE/2));
        walls.add(new Wall(FIELD_SELL_SIZE/2, FIELD_SELL_SIZE/2));

        return new GameObjects(walls, boxes, homes, player);
    }
}
