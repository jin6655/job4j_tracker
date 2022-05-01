package ru.job4j.oop;

public class Ball {

    public void tryRun(boolean condition) {
        if (condition) {
            System.out.println("был съеден");
        } else {
            System.out.println("убежал");
        }
    }
}
