package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class MemTracker implements Store {
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

    @Override
    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        int i = indexOf(id);
        if (i != -1) {
            item.setId(id);
            items.set(i, item);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        int i = indexOf(id);
        boolean rsl = false;
        if (i != -1) {
            items.remove(i);
            rsl = true;
        }
        return rsl;
    }

    @Override
    public List<Item> findAll() {
        return items;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> rsl = new ArrayList<>();
        for (Item i : items) {
            if (i.getName().equals(key)) {
                rsl.add(i);
            }
        }
        return rsl;
    }

    @Override
    public Item findById(int id) {
        int i = indexOf(id);
        return i != -1 ? items.get(i) : null;
    }

}