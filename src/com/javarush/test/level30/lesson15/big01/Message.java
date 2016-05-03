package com.javarush.test.level30.lesson15.big01;

import java.io.Serializable;

/**
 * Created by Alenka on 02.05.2016.
 */
public class Message implements Serializable
{
    private final MessageType type;
    private final String data;

    public String getData() {
        return data;
    }

    public MessageType getType() {
        return type;
    }

    public Message(MessageType type) {
        this.type = type;
        this.data = null;
    }

    public Message(MessageType type, String data) {
        this.type = type;
        this.data = data;
    }
}
