package ru.job4j.test01;

import ru.job4j.collection.DepDescComp;

import java.util.*;

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
        if (this == o)  {
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
        List<Caty> one = new ArrayList<>() {{
            add(caty01);
            add(caty02);
            add(caty03);
            add(caty04);
        }};
        LinkedHashSet<String> two = new LinkedHashSet<>();
        Map<Integer, String> three = new HashMap<>();
        Set<Caty> four = new TreeSet<>();
        List<String> i  = new ArrayList<>();
        String k = "K1/SK1/SSK1";
        String l = "K2/SK1";
        System.out.println(k.compareTo(l));
    }

}
