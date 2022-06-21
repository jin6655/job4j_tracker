package ru.job4j.collection;

import org.junit.Test;

import java.util.Comparator;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class JobTest {

    @Test
    public void whenComparatorByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Ampl task", 0),
                new Job("Ampl task", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorByNameAsk() {
        Comparator<Job> comp = new JobAskByName();
        int rsl = comp.compare(
                new Job("Ampl task", 0),
                new Job("Bmpl task", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorByPriotityAsk() {
        Comparator<Job> comp = new JobAskByPriority();
        int rsl = comp.compare(
                new Job("Ampl task", 0),
                new Job("Bmpl task", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorByPriotityDesc() {
        Comparator<Job> comp = new JobDescByPriority();
        int rsl = comp.compare(
                new Job("Ampl task", 0),
                new Job("Bmpl task", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorByNameDesc() {
        Comparator<Job> comp = new JobDescByName();
        int rsl = comp.compare(
                new Job("Ampl task", 0),
                new Job("Bmpl task", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorByNameDescPriorityAsk() {
        Comparator<Job> comp = new JobDescByName().thenComparing(new JobAskByPriority());
        int rsl = comp.compare(
                new Job("Ampl task", 0),
                new Job("Ampl task", 1)
        );
        assertThat(rsl, lessThan(0));
    }

}