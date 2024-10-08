package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class StartUI {

    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Store tracker, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.size()) {
                out.println("Wrong input, you can select: 0 .. " + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(List<UserAction> actions) {
        out.println("Menu:");
        for (int i = 0; i < actions.size(); i++) {
            out.println(i + ". " + actions.get(i).name());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        //реализация через память
        Store tracker = new MemTracker();
        List<UserAction> actions = List.of(
                new CreatActionByTestGC(output),
                new CreateAction(output),
                new ReplaceAction(output),
                new DeleteAction(output),
                new ShowItemAction(output),
                new Exit(output)
        );
        new StartUI(output).init(input, tracker, actions);

        //реализация через SQL
        /*try (SqlTracker tracker = new SqlTracker()) {
            tracker.init();
            List<UserAction> actions = List.of(
                    new CreateAction(output),
                    new ReplaceAction(output),
                    new DeleteAction(output),
                    new ShowItemAction(output),
                    new FindItemByIDAction(output),
                    new FindItemByNameAction(output),
                    new Exit(output)
            );
            new StartUI(output).init(input, tracker, actions);
        } catch (Exception e) {
            e.printStackTrace();
        }
         */
    }

}
