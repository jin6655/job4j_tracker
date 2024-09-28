package ru.job4j.tracker;

public class DeleteAction implements UserAction {

    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete item";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("== Delete item ==");
        int id = input.askInt("Enter id: ");
        boolean rsl = tracker.delete(id);
        if (rsl) {
            out.println("Application deleted");
        } else {
            out.println("Error deleting request.");
        }
        return true;
    }
}
