package com.arishenk;

public class Msg {
    private String to, from, title;

    public Msg(String to, String from, String title) {
        this.to = to;
        this.from = from;
        this.title = title;
    }

    public String getTo() {
        return to;
    }

    public String getFrom() {
        return from;
    }

    public String getTitle() {
        return title;
    }

}