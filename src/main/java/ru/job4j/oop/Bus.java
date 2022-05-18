package ru.job4j.oop;

public class Bus implements Vehicle {

    int x;

    public Bus(int size) {
        this.x = size;
    }

    @Override
    public void movie() {
        System.out.print(getClass().getSimpleName() + " : развозит детей ");
    }

    @Override
    public int size(int size) {
        System.out.println(", масса " + size * x + " кг");
        return size * x;
    }

    public static void main(String[] args) {

    }

}
