package ru.job4j.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class JobSorter {

    public static void main(String[] args) {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bugs", 4),
                new Job("Impl task", 2),
                new Job("Reboot server", 1),
                new Job("X task", 0)
        );
        System.out.println(jobs);
        Comparator<Job> comb01 = new JobDescByNameLn().thenComparing(new JobDescByName().thenComparing(new JobDescByPriority()));
        Collections.sort(jobs, comb01);
        System.out.println(" ");
        System.out.println("Cортировка по длине имени, по имени и приоритету:");
        for (Job i : jobs) {
            System.out.println(i);
        }

    }
}
