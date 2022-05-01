package ru.job4j.oop;

import java.net.SocketOption;

public class Cat {

    private String food;

    private String name;

    public void giveNick(String nick) {
        this.name = nick;
    }

    public void eat(String meat) {
        this.food = meat;
    }

    public void show() {
        System.out.println(this.food);
        System.out.println("Kote nick: " + this.name);
    }

    public String sound() {
        return "may-may";
    }

    public static void main(String[] args) {
        Cat peppy = new Cat();
        Cat sparky = new Cat();
        Cat molly = new Cat();
        System.out.println("Молли " + molly.sound());
        System.out.println("Peppy says " + peppy.sound());
        System.out.print("There are gav's food: ");
        Cat gav = new Cat();
        gav.giveNick("GavGav");
        gav.eat("kotleta");
        gav.show();
        System.out.print("There are black's food: ");
        Cat black = new Cat();
        black.giveNick("BlackEvil");
        black.eat("fish");
        black.show();
    }

}
