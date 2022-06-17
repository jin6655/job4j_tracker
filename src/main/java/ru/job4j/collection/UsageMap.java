package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {

    public static void main(String[] args) {
        HashMap<String, String> acc = new HashMap<>();
        acc.put("trup@mail.ru", "Vasily");
        acc.put("htr@mail.ru", "Genchik");
        acc.put("ser@mail.ru", "Olga");
        acc.put("ser@mail.ru", "Ivan");
        acc.replace("trup@mail.ru", "ReplaceName");
        for (String i : acc.keySet()) {
            String j = acc.get(i);
            System.out.print(j + " ");
        }
        System.out.println();
        for (Map.Entry<String, String> i : acc.entrySet()) {
            String k = i.getKey();
            String j = i.getValue();
            System.out.println(k + " " + j);
        }
    }

}
