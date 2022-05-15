package ru.job4j.poly;

public class Bus implements Transport {

    private int x;
    private String name;

    @Override
    public void drive() {
        System.out.println(name);
    }

    @Override
    public void passenger(int passengers) {
        this.x = passengers;
    }

    @Override
    public float refueling(int fuel) {
        float rate = (float) 80.20;
        float y = fuel * rate;
        return y;
    }

}
