package ru.job4j.tracker;

import java.util.List;

public class FindItemByNameAction implements UserAction {

    private Output out;

    public FindItemByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find item by name";
    }

    @Override
    public boolean execute(Input input, SqlTracker tracker) {
        out.println("== Find items by name ==");
        String name = input.askStr("Enter name: ");
        List<Item> item = tracker.findByName(name);
        if (item.size() > 0) {
            for (Item i : item) {
                out.println(i);
            }
        } else {
            out.println("Заявки с именем " + name + " не найдены.");
        }
        return true;
    }
}
