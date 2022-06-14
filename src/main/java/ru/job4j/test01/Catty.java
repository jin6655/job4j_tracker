package ru.job4j.test01;

import java.util.Arrays;
import java.util.Scanner;

public class Catty implements Cloneable {

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

    public void menu01() {
        String[] menu = {"1. Формулы"};
        System.out.println(menu[0]);
    }

    public int test() {
        int v = 2;
        return v;
    }

    public int sumyz() {
        return y + z;
    }

    public void sum() {
        System.out.println("Это вычисление простой формулы\n" + "* Формула: с = x + y + z; " + "y = " + y + "; z = " + z + "\n");
        boolean run = true;
        while (run) {
            Scanner scan = new Scanner(System.in);
            System.out.println("\nВведите значение x");
            int numx = scan.nextInt();
            x = numx;
            int summ = y + z + numx;
            System.out.println("\nПолучено значение x = " + numx + "; Расчёт: c = " + y + " + " + z + " + " + numx + "; Итог: с = " + summ + ";");
        }
    }

    public boolean printarray() {
        for (int i = 0; i < array.length; i++) {
            System.out.println(Integer.parseInt(array[i]));
        }
        return true;
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
        Catty catmenu = new Catty();
        Catty cattest = new Catty(2, 3);
        System.out.println("Привет!");
        System.out.println(catmenu.printarray());
        // catmenu.menu01();
        // catcalc.sum();
        //System.out.println(cattest.test());
    }

}
