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
    public boolean execute(Input input, SqlTracker tracker) {
        out.println("== Delete item ==");
        int id = Integer.parseInt(input.askStr("Enter id: "));
        boolean rsl = tracker.delete(id);
        if (rsl) {
            out.println("Заявка удалена.");
        } else {
            out.println("Ошибка удаления заявки.");
        }
        return true;
    }
}
