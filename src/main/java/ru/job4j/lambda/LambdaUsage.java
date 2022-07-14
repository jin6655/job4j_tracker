package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaUsage {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("eeeee", "a", "cccc", "dd", "bbb");
        Comparator<String> comparator = (left, right) -> {
            System.out.println("сравненеие " + right + "(" + right.length() + ") " + left + "(" + left.length() + ")");
            return Integer.compare(right.length(), left.length());
        };
        String[] names = {
                "Ivan",
                "Semen"
        };
        Comparator<String> lengthCmp = (left, right) -> {
            System.out.println("execute comparator");
            return Integer.compare(left.length(), right.length());
        };
        Arrays.sort(names, lengthCmp);
    }
}
