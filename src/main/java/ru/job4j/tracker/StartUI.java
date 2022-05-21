package ru.job4j.tracker;

public class StartUI {

    public static void creatItem(Input input, Tracker tracker) {
        System.out.println("== Create a new Item ==");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
        System.out.println("Добавленная заявка: " + item);
    }

    public static void showItem(Input input, Tracker tracker) {
        System.out.println("== Show all items ==");
        Item[] items = tracker.findAll();
        if (items.length > 0) {
            for (Item item : items) {
                System.out.println(item);
            }
        } else {
            System.out.println("Хранилище не содержит заявок");
        }
    }

    public static void editItem(Input input, Tracker tracker) {
        System.out.println("== Edit item ==");
        int id = Integer.parseInt(input.askStr("Enter id: "));
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.replace(id, item);
        if (tracker.replace(id, item)) {
            System.out.println("Заявка успешно изменена.");
        } else {
            System.out.println("Ошибка замены заявки.");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("== Delete item ==");
        int id = Integer.parseInt(input.askStr("Enter id: "));
        tracker.delete(id);
        if (tracker.delete(id)) {
            System.out.println("Заявка удалена.");
        } else {
            System.out.println("Ошибка удаления заявки.");
        }
    }

    public static void findItemById(Input input, Tracker tracker) {
        System.out.println("== Find items by id ==");
        int id = Integer.parseInt(input.askStr("Enter id: "));
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item);
        } else {
            System.out.println("Заявки с введённым id: " + id + " не найдена.");
        }
    }

    public static void findItemByName(Input input, Tracker tracker) {
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
    }

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            showMenu();
            int select = Integer.parseInt(input.askStr("Select: "));
            if (select == 0) {
                StartUI.creatItem(input, tracker);
            } else if (select == 1) {
                StartUI.showItem(input, tracker);
            } else if (select == 2) {
                StartUI.editItem(input, tracker);
            } else if (select == 3) {
                StartUI.deleteItem(input, tracker);
            } else if (select == 4) {
                StartUI.findItemById(input, tracker);
            } else if (select == 5) {
                StartUI.findItemByName(input, tracker);
            } else if (select == 6) {
                run = false;
            } else {
                System.out.println("Пользователь выбрал: " + select + " - операция не назначена");
            }
            System.out.println();
        }

    }

    private void showMenu() {
        String[] menu = {
                "Add new item", "Show all items", "Edit item",
                "Delete item", "find item by id", "Find item by name",
                "Exit Program"
        };
        System.out.println("Menu: ");
        for (int i = 0; i < menu.length; i++) {
            System.out.println(i + ". " + menu[i]);
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }

}
