package ru.job4j.tracker;

public class FindItemByNameAction implements UserAction {

    @Override
    public String name() {
        return "Find item by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("== Find items by name ==");
        String name = input.askStr("Enter name: ");
        Item[] item = tracker.findByName(name);
        if (item.length > 0) {
            for (Item i : item) {
                System.out.println(i);
            }
        } else {
            System.out.println("Заявки с именем " + name + " не найдены.");
        }
        return true;
    }
}
