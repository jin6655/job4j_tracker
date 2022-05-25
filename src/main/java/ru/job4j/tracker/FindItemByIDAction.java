package ru.job4j.tracker;

public class FindItemByIDAction implements UserAction {

    @Override
    public String name() {
        return "Find item by id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("== Find items by id ==");
        int id = Integer.parseInt(input.askStr("Enter id: "));
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item);
        } else {
            System.out.println("Заявки с введённым id: " + id + " не найдена.");
        }
        return true;
    }
}
