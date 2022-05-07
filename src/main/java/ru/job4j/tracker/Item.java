package ru.job4j.tracker;

public class Item {

    private int id;
    private String name;

    public Item() {
    }

    public Item(String one) {
        this.name = one;
    }

    public Item(int two, String one) {
        this.id = two;
        this.name = one;
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
}