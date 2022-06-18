package ru.job4j.test01;

import java.sql.SQLOutput;

public class Catty01 {

    public int sum(int x, int y) {
        Catty cattysumm = new Catty(2, 2);
        return x + y;
    }

    public static void main(String[] args) {
        //System.out.println(Catty01.sum(-30, 20));
        Catty01 catty01summ = new Catty01();
        System.out.println(catty01summ.sum(3, 3));
    }
}