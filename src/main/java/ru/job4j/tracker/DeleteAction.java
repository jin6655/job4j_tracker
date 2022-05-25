package ru.job4j.tracker;

public class DeleteAction implements UserAction {

    @Override
    public String name() {
        return "Delete item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("== Delete item ==");
        int id = Integer.parseInt(input.askStr("Enter id: "));
        boolean rsl = tracker.delete(id);
        if (rsl) {
            System.out.println("Заявка удалена.");
        } else {
            System.out.println("Ошибка удаления заявки.");
        }
        return true;
    }
}
