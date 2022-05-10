package ru.job4j.pojo;

public class Library {

    public static void main(String[] args) {
        Book novel = new Book("Gone With the Wind", 120);
        Book thriller = new Book("Wind and horror", 140);
        Book comedy = new Book("Wind and Jim", 250);
        Book textbook = new Book("Clean code", 450);
        Book[] directory = new Book[4];
        directory[0] = novel;
        directory[1] = thriller;
        directory[2] = comedy;
        directory[3] = textbook;
        System.out.println("directory: ");
        for (int i = 0; i < directory.length; i++) {
            Book dir = directory[i];
            System.out.println(dir.getName() + ", pages: " + dir.getPages());
        }
        System.out.println();
        System.out.println("directory with permutation: ");
        for (int i = 0; i < directory.length; i++) {
            if (i == 0) {
                Book temp = directory[i];
                directory[i] = directory[3];
                directory[3] = temp;
            }
            Book dir = directory[i];
            System.out.println(dir.getName() + ", pages: " + dir.getPages());
        }
        System.out.println();
        System.out.println("directory with Clean code: ");
        for (int i = 0; i < directory.length; i++) {
            Book dir = directory[i];
            if (dir.getName() == "Clean code") {
                System.out.println(dir.getName() + ", pages: " + dir.getPages());
                break;
            }
        }
    }

}
