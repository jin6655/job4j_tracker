package ru.job4j.tracker;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ReplaceActionTest {

    @Test
    public void whenReplace() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        ReplaceAction rep = new ReplaceAction(out);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        when(input.askStr(any(String.class))).thenReturn(replacedName);
        rep.execute(input, tracker);
        String ln = System.lineSeparator();
        MatcherAssert.assertThat(out.toString(),
                Matchers.is("=== Edit item ===" + ln + "Replaced item" + ln)
                );
        MatcherAssert.assertThat(tracker.findAll().get(0).getName(), Matchers.is(replacedName));
    }

    @Test
    public void whenNotReplace() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        ReplaceAction rep = new ReplaceAction(out);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(2);
        when(input.askStr(any(String.class))).thenReturn(replacedName);
        rep.execute(input, tracker);
        String ln = System.lineSeparator();
        MatcherAssert.assertThat(out.toString(),
                Matchers.is("=== Edit item ===" + ln + "No id found with this." + ln)
        );

        when(input.askInt(any(String.class))).thenReturn(1);
        when(input.askStr(any(String.class))).thenReturn(replacedName);
        rep.execute(input, tracker);
        MatcherAssert.assertThat(tracker.findAll().get(0).getName(), Matchers.is(replacedName));
    }

}