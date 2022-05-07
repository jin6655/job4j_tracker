package ru.job4j.max;

public class Reduce {

    private int[] x;

    public void to(int[] array) {
        this.x = array;
    }

    public void print() {
        for (int index = 0; index < x.length; index++) {
    System.out.println(x[index]);
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4};
        Reduce reduce = new Reduce();
        reduce.to(array);
        reduce.print();
    }

}
