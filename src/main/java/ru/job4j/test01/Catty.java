package ru.job4j.test01;

import java.util.Scanner;

public class Catty {

    private int x;
    private int y;
    private int z;

    public Catty() {
    }

    public Catty(int a, int b) {
        this.y = a;
        this.z = b;
    }

    public void menu01() {
        String[] menu = {"1. Формулы"};
        System.out.println(menu[0]);
    }

    public int test() {
        int v = 2;
        return v;
    }

    public void sum() {
        System.out.println("Это вычисление простой формулы\n" + "* Формула: с = x + y + z; " + "y = " + this.y + "; z = " + this.z + "\n");
        boolean run = true;
        while (run) {
            Scanner scan = new Scanner(System.in);
            System.out.println("\nВведите значение x");
            int numx = scan.nextInt();
            this.x = numx;
            int summ = this.y + this.z + numx;
            System.out.println("\nПолучено значение x = " + numx + "; Расчёт: c = " + this.y + " + " + this.z + " + " + numx + "; Итог: с = " + summ + ";");
        }
    }

    public static void main(String[] args) {
        Catty catcalc = new Catty(30, 20);
        Catty catmenu = new Catty();
        Catty cattest = new Catty();
        System.out.println("Привет!");
        // catmenu.menu01();
        // catcalc.sum();
        System.out.println(cattest.test());
    }

}
