package ru.job4j.oop;

public class Train implements Vehicle {

    int x;

    public Train(int size) {
        this.x = size;
    }

    @Override
    public void movie() {
        System.out.print(getClass().getSimpleName() + " : несётся по рельсам ");
    }

    @Override
    public int size(int size) {
        System.out.println(", масса " + size * x + " кг");
        return size * x;
    }

    public static void main(String[] args) {

    }
}
