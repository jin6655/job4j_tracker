package ru.job4j.oop;

public interface Vehicle {

    void movie();

    int size(int size);

    public static void main(String[] args) {
        Vehicle plane  = new Airplane(10);
        Vehicle train = new Train(20);
        Vehicle bus = new Bus(50);
        Vehicle[] vehicle = new Vehicle[]{plane, train, bus};
        for (Vehicle i: vehicle) {
            i.movie();
            i.size(10);
        }
    }

}
