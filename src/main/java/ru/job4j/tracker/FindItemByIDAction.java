package ru.job4j.tracker;

public class FindItemByIDAction implements UserAction {

    private final Output out;

    public FindItemByIDAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find item by id";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("== Find items by id ==");
        int id = input.askInt("Enter id: ");
        Item item = tracker.findById(id);
        if (item != null) {
            out.println(item);
        } else {
            out.println("Request with id " + id + " not found.");
        }
        return true;
    }
}
