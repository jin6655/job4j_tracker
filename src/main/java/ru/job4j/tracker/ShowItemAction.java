package ru.job4j.tracker;

import java.util.List;

public class ShowItemAction implements UserAction {

    private  final Output out;

    public ShowItemAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("== Show all items ==");
        List<Item> items = tracker.findAll();
        if (items.size() > 0) {
            for (Item item : items) {
                out.println(item);
            }
        } else {
            out.println("Хранилище не содержит заявок");
        }
        return true;
    }
}
