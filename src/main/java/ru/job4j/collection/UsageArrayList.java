package ru.job4j.collection;

import java.util.ArrayList;

public class UsageArrayList {

    public static void main(String[] args) {
        ArrayList<String> name = new ArrayList<>();
        name.add("Petr");
        name.add("Iva");
        name.add("Stepan");
        name.add(3, "Ivan");
        name.set(0, "Vasily");
        for (Object value : name) {
            System.out.println(value);
        }
    }

}
