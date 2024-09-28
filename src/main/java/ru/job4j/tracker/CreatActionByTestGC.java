package ru.job4j.tracker;

import org.apache.commons.lang.RandomStringUtils;

public class CreatActionByTestGC implements UserAction {

    private final Output out;

    public CreatActionByTestGC(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "CreateTestGC";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("== Create a new Item ==");
        //String name = new StringBuilder().append(input.askStr("Enter name: ")).append(new String[10000].toString()).toString();
        String name = new StringBuilder().append(input.askStr("EnterName: ")).append(RandomStringUtils.randomAlphabetic(1000000)).toString();
        Item item = new Item(name);
        tracker.add(item);
        out.println("Добавленная заявка: " + item);
        return true;
    }
}
