package com.Arshan.models.entity;

import javax.print.attribute.standard.Severity;
import java.util.Date;

public class Crime {
    private int id;
    private String title;

    public Crime(String title) {
        this.title = title;
    }

    public Crime(int id, String title) {
        this.id = id;
        this(title);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
