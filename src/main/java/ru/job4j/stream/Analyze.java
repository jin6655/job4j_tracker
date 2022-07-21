package ru.job4j.stream;

import ru.job4j.map.Subject;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Optional.*;

public class Analyze {

    public static double averageScore(Stream<Pupil> stream) {
        return stream.flatMap(s -> s.getSubjects().stream())
                .mapToInt(e -> e.getScore())
                .average()
                .orElse(0D);
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream
                .map(s -> new Tuple(s.getName(), s.getSubjects()
                        .stream()
                        .mapToInt(d -> d.getScore())
                        .average()
                        .orElse(0D)))
                .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream.flatMap(s -> s.getSubjects().stream())
                .collect(Collectors.groupingBy(
                        e -> e.getName(),
                        LinkedHashMap::new,
                        Collectors.averagingDouble(f -> f.getScore())))
                .entrySet().stream()
                .map(g -> new Tuple(g.getKey(), g.getValue()))
                .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream
                .map(s -> new Tuple(s.getName(), s.getSubjects()
                        .stream()
                        .mapToInt(d -> d.getScore())
                        .sum()))
                .max(new Comparator<Tuple>() {
                    @Override
                    public int compare(Tuple o1, Tuple o2) {
                        return Integer.compare((int) o1.getScore(), (int) o2.getScore());
                    }
                })
                .orElse(null);
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream.flatMap(s -> s.getSubjects().stream())
                .collect(Collectors.groupingBy(e -> e.getName(), LinkedHashMap::new, Collectors.summingDouble(f -> f.getScore())))
                .entrySet().stream()
                .map(g -> new Tuple(g.getKey(), g.getValue()))
                .collect(Collectors.toList()).stream()
                .max(new Comparator<Tuple>() {
                    @Override
                    public int compare(Tuple o1, Tuple o2) {
                        return Integer.compare((int) o1.getScore(), (int) o2.getScore());
                    }
                })
                .orElse(null);
    }

}
