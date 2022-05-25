package ru.job4j.strategy;

public class Paint {

    public static void draw(Shape shape) {
        System.out.println(shape.draw());
    }

    public static void main(String[] args) {
        Shape triangle = new Triangle();
        Shape square = new Square();
        Paint.draw(triangle);
        Paint.draw(square);
    }
}
