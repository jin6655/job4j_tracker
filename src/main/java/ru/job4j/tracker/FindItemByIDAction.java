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
    public boolean execute(Input input, SqlTracker tracker) {
        out.println("== Find items by id ==");
        int id = Integer.parseInt(input.askStr("Enter id: "));
        Item item = tracker.findById(id);
        if (item != null) {
            out.println(item);
        } else {
            out.println("Заявки с введённым id: " + id + " не найдена.");
        }
        return true;
    }
}
