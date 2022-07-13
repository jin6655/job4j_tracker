package ru.job4j.collection;

import java.util.*;

public class Departments {

    public static List<String> fillGaps(List<String> deps) {
        List<String> rsl = new ArrayList<>();
        LinkedHashSet<String> set = new LinkedHashSet<>();
        for (String i : deps) {
            String[] j = i.split("/");
            String el = "";
            for (String h : j) {
                set.add(el + h);
                el += h + "/";
            }
        }
        rsl.addAll(set);
        return rsl;
    }

    public static void sortAsc(List<String> orgs) {
        orgs.sort(Comparator.naturalOrder());
    }

    public static void sortDesc(List<String> orgs) {
        orgs.sort(new DepDescComp());
    }

}
