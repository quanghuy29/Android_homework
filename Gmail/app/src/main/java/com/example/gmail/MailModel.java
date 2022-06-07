package com.example.gmail;

public class MailModel {
    public String name;
    public String topic;
    public String content;
    public String time;

    public MailModel(String name, String topic, String content, String time) {
        this.name = name;
        this.topic = topic;
        this.content = content;
        this.time = time;
    }
}
