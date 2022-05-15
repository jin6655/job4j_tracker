package ru.job4j.poly;

public class Bus implements Transport {

    private int x;

    @Override
    public void drive() {
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
