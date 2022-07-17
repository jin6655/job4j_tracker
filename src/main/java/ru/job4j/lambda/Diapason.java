package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.function.*;
import java.util.List;

public class Diapason {

    public List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> rsl = new ArrayList<>();
        for (int i = start; i < end; i++) {
            double x = i;
            rsl.add(func.apply(x));
        }
        return rsl;
    }
}
