package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tracker {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;
    private int size = 0;

    private int indexOf(int id) {
        int rsl = -1;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId() == id) {
                rsl = i;
                break;
            }
        }
        return rsl;
    }

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public List<Item> findAll() {
        return items;
    }

    public List<Item> findByName(String key) {
        List<Item> rsl = new ArrayList<>();
        for (Item i : items) {
            if (i.getName().equals(key)) {
                rsl.add(i);
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        int i = indexOf(id);
        return i != -1 ? items.get(i) : null;
    }

    public boolean replace(int id, Item item) {
        int i = indexOf(id);
        if (i != -1) {
            item.setId(id);
            items.set(i, item);
            return true;
        }
        return false;
    }

    public boolean delete(int id) {
        int i = indexOf(id);
        boolean rsl = false;
        if (i != -1) {
            items.remove(i);
            rsl = true;
        }
        return rsl;
    }

}