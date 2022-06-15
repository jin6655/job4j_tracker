package ru.job4j.collection;

import ru.job4j.tracker.Item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UsageArrayList {

    public static void main(String[] args) {
        List<Item> name = new ArrayList<>();
        List<Integer> age = new ArrayList<>();
        Item item01 = new Item(2, "Petr");
        Item item02 = new Item(5, "Vasily");
        Item item03 = new Item(10, "Semka");
        name.add(item01);
        name.add(item02);
        name.add(item03);
        age.add(0, 5);
        age.add(1, 5);
        age.add(2, 89);
        age.add(1, 55);
        for (Object value : name) {
            System.out.println(value);
        }
        System.out.println(age);
    }

}
