package ru.job4j.collection;

import java.util.ArrayList;

public class UsageArrayList {

    public static void main(String[] args) {
        ArrayList<String> name = new ArrayList<>();
        name.add("Petr");
        name.add("1");
        name.add("Stepan");
        name.set(0, "Vasily");
        name.remove("Ivan");
        for (Object value : name) {
            System.out.println(value);
        }
    }

}
