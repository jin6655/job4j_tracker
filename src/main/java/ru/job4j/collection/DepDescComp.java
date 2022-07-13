package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        String[] i = o1.split("/");
        String[] j = o2.split("/");
        int rsl = 0;
        if (i[0].equals(j[0])) {
            rsl =  o1.compareTo(o2);
        } else {
            rsl = o2.compareTo(o1);
        }
        return rsl;
    }

}

