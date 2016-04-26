package com.javarush.test.level27.lesson15.big01.statistic;

import com.javarush.test.level27.lesson15.big01.statistic.event.EventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Alenka on 25.04.2016.
 */
public class StatisticManager
{
    private static StatisticManager ourInstance = new StatisticManager();
    private static StatisticStorage statisticStorage = StatisticManager.getInstance().new StatisticStorage();

    public static StatisticManager getInstance() {
        return ourInstance;
    }

    private StatisticManager() {
    }

    public void register(EventDataRow data) {
        statisticStorage.put(data);
    }

    private class StatisticStorage {

        private Map<EventType, List<EventDataRow>> eventMapStorage = new HashMap<>();;

        private StatisticStorage() {
            for (EventType eventType  : EventType.values()) {
                eventMapStorage.put(eventType , new ArrayList<EventDataRow>());
            }
        }

        private void put(EventDataRow data) {
            eventMapStorage.get(data.getType()).add(data);
        }

    }
}
