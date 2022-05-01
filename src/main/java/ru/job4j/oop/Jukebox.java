package ru.job4j.oop;

public class Jukebox {

    public void music(int position) {
    if (position == 1) {
        System.out.println("1: Пусть бегут неуклюже");
    } else if (position == 2) {
        System.out.println("2: Спокойной ночи");
    } else {
        System.out.println("error: Песня не найдена");
    }
    }

    public static void main(String[] args) {
        Jukebox best = new Jukebox();
        best.music(1);
        best.music(2);
        best.music(3);
    }

}
