package ru.job4j.oop;

public class BallStory {

    public static void main(String[] args) {
        Ball ball = new Ball();
        Hare hare = new Hare();
        Wolf wolf = new Wolf();
        Fox fox = new Fox();
        System.out.println("Жил был колобок. Убежал от дедки, убежал от бабки.");
        System.out.print("Встретил зайца и ");
        hare.tryEat(ball);
        System.out.print("Встретил волка и ");
        wolf.tryEat(ball);
        System.out.print("Встретил лису и ");
        fox.tryEat(ball);
        System.out.println();
        }

    }