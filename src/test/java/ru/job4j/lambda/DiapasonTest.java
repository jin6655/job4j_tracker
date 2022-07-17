package ru.job4j.lambda;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.*;
import java.util.List;

public class DiapasonTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        Diapason function = new Diapason();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenLinearResult() {
        Diapason function = new Diapason();
        List<Double> result = function.diapason(5, 8, x -> 3 * Math.pow(x, 2) + 2 * x + 1);
        List<Double> expected = Arrays.asList(86D, 121D, 162D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExponentialFunctionThenLinerResult() {
        Diapason function = new Diapason();
        List<Double> result = function.diapason(5, 8, x -> 2 * x);
        List<Double> expected = Arrays.asList(10D, 12D, 14D);
        assertThat(result, is(expected));
    }

}