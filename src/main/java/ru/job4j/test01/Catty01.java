package ru.job4j.test01;

import java.sql.SQLOutput;

public class Catty01 {

    public static boolean sum(int x, int y) {
        boolean rsl = false;
        if ((x + y) > 0) {
            return true;
        }
        return rsl;
    }

    public static void main(String[] args) {
        System.out.println(Catty01.sum(-30, 20));
    }
}
