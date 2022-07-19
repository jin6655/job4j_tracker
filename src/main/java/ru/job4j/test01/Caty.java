package ru.job4j.test01;

import jdk.dynalink.Operation;
import ru.job4j.collection.DepDescComp;
import ru.job4j.oop.Cat;
import ru.job4j.tracker.StubOutput;

import javax.swing.text.AttributeSet;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public Caty(int x) {
        this.x = x;
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
        Caty caty02 = new Caty(2, "Di");
        Caty caty03 = new Caty(1, "Blut");
        Caty caty04 = new Caty(3, "A");
        System.out.println("Привет!");
        List<String> i = new ArrayList<>(List.of("a", "b"));
        i.stream().forEach(s -> System.out.print(s + " "));
        //Map.of(1, "a", 2, "b", 3, "c").forEach((v, k) -> System.out.println(v + " " + k));
    }

}
