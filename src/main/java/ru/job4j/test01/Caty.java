package ru.job4j.test01;

import ru.job4j.map.Subject;
import ru.job4j.stream.Pupil;
import ru.job4j.tracker.StubOutput;

import java.math.*;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Caty {

 private int x;
 private int y;
 private String str;

    public Caty(int x, int y, String str) {
        this.x = x;
        this.y = y;
        this.str = str;
    }

    @Override
    public String toString() {
        return "{" + "x = " + x + ", "
                + "y = " + y + ", "
                + "str = " + str + "}";
    }

    public static void main(String[] args) {
        List<String> a = List.of("a", "b", "c");
        a.stream().map(s -> s + "! ").forEach(System.out::print);
    }

}
