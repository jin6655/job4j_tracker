package ru.job4j.test01;

import jdk.dynalink.Operation;
import ru.job4j.collection.DepDescComp;
import ru.job4j.tracker.StubOutput;

import java.util.*;
import java.util.function.*;

public class Caty implements Comparable<Caty> {

    private int x;
    private int y;
    private int z;
    private String str;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public Caty() {
    }

    public Caty(int x, String str) {
        this.x = x;
        this.str = str;
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
    public int compareTo(Caty o) {
        return Integer.compare(x, o.getX());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Caty caty = (Caty) o;
        return Objects.equals(str, caty.str);
    }

    @Override
    public int hashCode() {
        return Objects.hash(str);
    }

    @Override
    public String toString() {
        return x + " " + str;
    }

    public static void main(String[] args) {
        Caty caty01 = new Caty(3, "Caty my love");
        Caty caty02 = new Caty(2, "Hi");
        Caty caty03 = new Caty(1, "Blut");
        Caty caty04 = new Caty(4, "A");
        System.out.println("Привет!");
        int rsl = 0;
        int[] ms = {1, 2, 3};
        List<Integer[]> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        int cl = 0;
        for (int k = 0; k < ms.length; k++) {
            i++;
            j++;
            Integer[] l = {i, j};
            list.add(l);
            int finalI = i;
            int finalJ = j;
            int h = cl;
            cl = calcc(
                    () -> {
                        int f = finalI + finalJ;
                        System.out.println(finalI + " + " + finalJ + " = " + f);
                        return f + h;
                    }
            );
            rsl = cl;
        }
        for (Integer[] z : list) {
            for (int k = 0; k < z.length; k++) {
                System.out.print(z[k] + " ");
            }
        }
        System.out.println();
        System.out.println(rsl);
    }

    private static Integer calcc(Supplier<Integer> calc) {
        return calc.get();
    }

}
