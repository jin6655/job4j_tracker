package ru.job4j.oop;

public class Airplane implements Vehicle {

    int x;

    public Airplane(int size) {
        this.x = size;
    }

    @Override
    public void movie() {
        System.out.print(getClass().getSimpleName() + " : летает в облаках ");
    }

    @Override
    public int size(int size) {
        System.out.println(", масса " + size * x + " кг");
        return size * x;
    }
/*
    public static void main(String[] args) {
        Vehicle plane = new Airplane(1);
        Vehicle plane02 = new Airplane(2);
        Vehicle plane03 = new Airplane(3);
        Vehicle[] airplane = new Vehicle[]{plane, plane02, plane03};
        for (Vehicle i: airplane) {
            i.movie();
            i.size(10);
        }
    }

 */

}
