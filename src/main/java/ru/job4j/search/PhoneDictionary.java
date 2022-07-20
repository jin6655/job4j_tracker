package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {

    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
    this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> prName = (s) -> s.getName().contains(key);
        Predicate<Person> prSurname = (s) -> s.getSurname().contains(key);
        Predicate<Person> prAddress = (s) -> s.getAddress().contains(key);
        Predicate<Person> prPhone = (s) -> s.getPhone().contains(key);
        Predicate<Person> pr = prName.or(prSurname).or(prAddress).or(prPhone);
        var rsl = new ArrayList<Person>();
        for (var i : persons) {
            if (pr.test(i)) {
                rsl.add(i);
            }
        }
        return rsl;
    }
}
