package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int adc) {
        return adc - x;
    }

    public int multiply(int a) {
        return x * a;
    }

    public int divide(int afg) {
        return afg / x;
    }

    public int sumAllOperation(int y, int adc, int a, int afg) {
        return  Calculator.sum(y) + Calculator.minus(adc) + multiply(a) + divide(afg);
    }

    public static void main(String[] args) {
        Calculator mult = new Calculator();
        Calculator div = new Calculator();
        Calculator sumAll = new Calculator();
        System.out.println("х = " + x + ", y = 5" + ", adc = 8" + ", a = 2" + ", afg = 10");
        System.out.println("summ = x + y = " + sum(5));
        System.out.println("minus = adc - x = " + minus(8));
        System.out.println("multiply = x * a = " + mult.multiply(2));
        System.out.println("divide = afg / x = " + div.divide(10));
        System.out.println("sum all = summ + minus + multiply + divide = " + sumAll.sumAllOperation(5, 8, 2, 10));
    }

}
