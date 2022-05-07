package ru.job4j.oop;

public class Computer {

    private boolean multiMonitor;
    private int ssd;
    private String cpu;

    public Computer(boolean multiMonitor, int ssd, String cpu) {
       this.multiMonitor = multiMonitor;
       this.ssd = ssd;
       this.cpu = cpu;
    }

    public Computer(boolean multiMonitor, double ssd, String cpu) {
        this.multiMonitor = multiMonitor;
        this.ssd = (int) ssd;
        this.cpu = cpu;
    }

    public Computer() {

    }

    public void printInfo() {
        System.out.println("Много мониторов: " + multiMonitor);
        System.out.println("SSD: " + ssd + " GB");
        System.out.println("Модель CPU: " + cpu);
    }

    public static void main(String[] args) {
        Computer computer = new Computer(true,  500, "Intel Core I7-10799K");
        Computer computerNull = new Computer();
        Computer computer02 = new Computer(true, 90.23, "Int 800");
        computer.printInfo();
        System.out.println();
        computer02.printInfo();
        System.out.println();
        computerNull.printInfo();
    }

}
