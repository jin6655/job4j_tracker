package ru.job4j.function;

import ru.job4j.tracker.StubOutput;

import java.util.*;
import java.util.function.*;

public class FunctionInterfaceUsage {

    public static void main(String[] args) {
        String a = "New String for Interface";
        String d = "";
        System.out.println("пример Supplier");
        List<String> list = List.of("one", "two", "free", "one");
        Supplier<Set<String>> supp = () -> new HashSet<>(list);
        Set<String> z = supp.get();
        for (String i : z) {
            System.out.print(i + " ");
        }
        System.out.println("\nпример Consumer");
        Consumer<Set<String>> st = (g) -> System.out.println(g);
        st.accept(supp.get());
        System.out.println("пример BiConsumer");
        BiConsumer<String, String> ca = (c, c1) -> System.out.println(c + c1);
        ca.accept(a, d);
        BiConsumer<Integer, String> cb = (c, c1) -> System.out.print(c + c1);
        int j = 1;
        for (String i : z) {
            cb.accept(j++, " " + i + " / ");
        }
        System.out.println("\nпример Predicate");
        Predicate<String> pr = (s) -> s.isEmpty();
        System.out.println("Пустая строка: " + pr.test(a));
        System.out.println("Пустая строка: " + pr.test(d));
        BiPredicate<String, Integer> prd = (s, s1) -> s.contains(s1.toString());
        System.out.println("Строка Num123 содержит число 123: " + prd.test("Num123", 123));
        System.out.println("Строка Num содержит число 123: " + prd.test("Num", 123));
        System.out.println("Пример Function");
        Function<String, Boolean> fn = (s) -> s.isEmpty();
        System.out.println("Третий символ в строке one: " + fn.apply("o"));
        System.out.println("Третий символ в строке two: " + fn.apply(""));
        BiFunction<String, Integer, String> fnc = (s, s1) -> s.concat(" ").concat(s1.toString());
        System.out.println("Объединение строки AB и числа 120: " + fnc.apply("АB", 120));
    }

}
