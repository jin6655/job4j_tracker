package ru.job4j.search;

import java.util.ArrayList;

public class PhoneDictionary {

    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
    this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        for (Person i : persons) {
            String[] j = {i.getName(), i.getSurname(), i.getPhone(), i.getAddress()};
            for (int k = 0; k < j.length; k++) {
                if (j[k].indexOf(key) != -1) {
                    result.add(i);
                }
            }
        }
        return result;
    }

}
