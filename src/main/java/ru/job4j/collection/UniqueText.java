package ru.job4j.collection;

import java.util.HashSet;

public class UniqueText {

    public static  boolean isEquals(String originText, String duplicateText) {
        boolean rsl = true;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> chek = new HashSet<>();
        for (String i : origin) {
            chek.add(i);
        }
        for (String i : text) {
            if (!chek.contains(i)) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }

}
