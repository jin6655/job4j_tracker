package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    private int indexOf(int id) {
        int rsl = -1;
        for (int i = 0; i < size; i++) {
            if (items[i].getId() == id) {
                rsl = i;
                break;
            }
        }
        return rsl;
    }

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String key) {
        Item[] rsl = new Item[items.length];
        int x = 0;
        for (int i = 0; i < items.length; i++) {
            Item name = items[i];
            if (name != null && name.getName() == key) {
                rsl[x++] = name;
            }
        }
        return Arrays.copyOf(rsl, x);
    }

    public Item findById(int id) {
        int i = indexOf(id);
        return i != -1 ? items[i] : null;
    }

    public boolean replace(int id, Item item) {
        boolean rsl = false;
        int i = indexOf(id);
        if (i != -1) {
            item.setId(id);
            items[i] = item;
            rsl = true;
        }
        return rsl;
    }

    public boolean delete(int id) {
        boolean rsl = false;
        int x = indexOf(id);
        if (x != -1) {
            items[x] = null;
            System.arraycopy(items, x + 1, items, x, size - x - 1);
            items[size - 1] = null;
            size = size - 1;
            rsl = true;
        }
        return rsl;
    }

}