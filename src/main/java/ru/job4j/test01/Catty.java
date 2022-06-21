package ru.job4j.test01;

import java.util.Arrays;
import java.util.Scanner;

public class Catty implements Cloneable, Comparable<String> {

    private int x;
    private int y;
    private int z;
    private String[] array = {"1", "2"};

    public Catty() {
    }

    public Catty(int y, int z) {
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    @Override
    public String toString() {
        return "Catty{"
                + "x=" + x
                + ", y=" + y
                + ", z=" + z
                + ", array=" + Arrays.toString(array)
                + '}';
    }

    public static void main(String[] args) {
        Catty catcalc = new Catty(30, 20);
        Catty cattest = new Catty(2, 3);
        Catty catmenu = new Catty();
        System.out.println("Привет!");
        String x = "Ivanovahhhhhhhh";
        String y = "Ivknovk";
        System.out.println(x.compareTo(y));
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }
}
