package ru.job4j.inheritance;

public class Builder extends Engineer {

    private int bricks;

    public Builder(int y, boolean x, String name, String surname, String education, String birthday) {
        super(x, name, surname, education, birthday);
        this.bricks = y;
    }

    public void bricks(int bricks) {
        System.out.println(getEducation());
        System.out.println("Украдено кирпичей: " + bricks);
    }

    public static void main(String[] args) {
        Builder brick = new Builder(10, false, "Семён", "Шохов", "строитель", "12.05.2005");
        brick.bricks(200);
    }
}
