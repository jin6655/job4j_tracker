package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int x = 0;
        for (int i = 0; i < Math.min(left.length(), right.length()); i++) {
            int y = Character.compare(left.charAt(i), right.charAt(i));
            if (y != 0) {
                return y;
            }
        }
        return Integer.compare(left.length(), right.length());
    }

}
