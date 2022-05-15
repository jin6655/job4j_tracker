package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            showMenu();
            System.out.println("Select: ");
            int select = Integer.parseInt(scanner.nextLine());
            if (select == 0) {
                System.out.println("== Create a new Item ==");
                System.out.println("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
                System.out.println("Добавленная заявка: " + item);
            } else if (select == 1) {
                System.out.println("== Show all items ==");
                Item[] items = tracker.findAll();
                if (items.length > 0) {
                    for (Item item : items) {
                        System.out.println(item);
                    }
                } else {
                    System.out.println("Хранилище не содержит заявок");
                }
            } else if (select == 2) {
                System.out.println("== Edit item ==");
                System.out.println("Enter id: ");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.replace(id, item);
                if (tracker.replace(id, item)) {
                    System.out.println("Заявка успешно изменена.");
                } else {
                    System.out.println("Ошибка замены заявка.");
                }
            } else if (select == 3) {
                System.out.println("== Delete item ==");
                System.out.println("Enter id: ");
                int id = Integer.parseInt(scanner.nextLine());
                tracker.delete(id);
                if (tracker.delete(id)) {
                    System.out.println("Заявка удалена.");
                } else {
                    System.out.println("Ошибка удаления заявки.");
                }
            } else if (select == 4) {
                System.out.println("== Find items by id ==");
                System.out.println("Enter id: ");
                int id = Integer.parseInt(scanner.nextLine());
                Item item = tracker.findById(id);
                if (item != null) {
                    System.out.println(item);
                } else {
                    System.out.println("Заявки с введённым id: " + id + " не найдена.");
                }
            } else if (select == 5) {
                System.out.println("== Find items by name ==");
                System.out.println("Enter name: ");
                String name = scanner.nextLine();
                Item[] item = tracker.findByName(name);
                if (item.length > 0) {
                    for (Item i : item) {
                        System.out.println(i);
                    }
                } else {
                    System.out.println("Заявки с именем " + name + " не найдены.");
                }
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
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }

}
