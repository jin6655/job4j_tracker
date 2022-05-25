package ru.job4j.tracker;

public class EditItemAction implements UserAction {

    @Override
    public String name() {
        return "Edit item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("== Edit item ==");
        int id = Integer.parseInt(input.askStr("Enter id: "));
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        boolean rsl = tracker.replace(id, item);
        if (rsl) {
            System.out.println("Заявка успешно изменена.");
        } else {
            System.out.println("Ошибка замены заявки.");
        }
        return true;
    }
}
