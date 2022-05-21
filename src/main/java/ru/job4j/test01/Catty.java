package ru.job4j.test01;

import java.util.Scanner;

public class Catty {

    private int x;
    private int y;
    private int z;

    public Catty(int a, int b) {
        this.y = a;
        this.z = b;
    }

    public void sum(int numy, int numz) {
        boolean run = true;
        while (run) {
            this.y = numy;
            this.z = numz;
            Scanner scan = new Scanner(System.in);
            System.out.println("\nФормула: с = x + y + z;\n" + "y = " + numy + "; z = " + numz + "\n\n" + "Введите значение x");
            int numx = scan.nextInt();
            this.x = numx;
            int summ = numy + numz + numx;
            System.out.println("\nПолучено значение x = " + numx + "\nc = " + numy + " + " + numz + " + " + numx + ";\nс = " + summ + ";");
        }
    }

    public static void main(String[] args) {
        Catty cat = new Catty(30, 20);
        cat.sum(20, 30);
    }

}
