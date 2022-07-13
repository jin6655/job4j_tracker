package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Attachment {

    private String name;
    private int size;

    public Attachment(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Attachment{"
                + "name='" + name + '\''
                + ", size=" + size
                + '}';
    }

    public static void main(String[] args) {
        List<Attachment> attachment = Arrays.asList(
                new Attachment("image 1", 100),
                new Attachment("image 4", 34),
                new Attachment("image 3", 13)
        );
        Comparator<Attachment> comp = new Comparator<Attachment>() {
            @Override
            public int compare(Attachment o1, Attachment o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        for (Attachment i : attachment) {
            System.out.println(i);
        }
        attachment.sort(comp);
        System.out.println();
        for (Attachment i : attachment) {
            System.out.println(i);
        }
    }

}
