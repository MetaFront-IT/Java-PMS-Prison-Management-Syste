package com.Arshan.models.entity;

public class Block {
    private int id;
    private String name;

    public Block(String name) {
        this.name = name;
    }

    public Block(int id, String name) {
        this.id = id;
        this(name);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Block{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
