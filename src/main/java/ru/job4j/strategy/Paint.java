package ru.job4j.strategy;

public class Paint {

    public static void draw(Shape shape) {
        System.out.println(shape.draw());
    }

    public static void main(String[] args) {
        Paint.draw(new Triangle());
        Paint.draw(new Square());
    }
}
