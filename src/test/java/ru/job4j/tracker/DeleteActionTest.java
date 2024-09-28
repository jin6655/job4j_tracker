package ru.job4j.tracker;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DeleteActionTest {

    @Test
    public void whenDeleteItem() {
        MemTracker tracker = new MemTracker();
        Output out = new StubOutput();
        tracker.add(new Item("Delete item"));
        DeleteAction deleteAction = new DeleteAction(out);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        deleteAction.execute(input, tracker);
        String ln = System.lineSeparator();
        MatcherAssert.assertThat(out.toString(),
                Matchers.is("== Delete item ==" + ln + "Application deleted" + ln)
        );
        MatcherAssert.assertThat(tracker.findAll().size(), Matchers.is(0));
    }

    @Test
    public void whenNoDeleteItem() {
        MemTracker tracker = new MemTracker();
        Output out = new StubOutput();
        tracker.add(new Item("Delete item"));
        DeleteAction deleteAction = new DeleteAction(out);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(2);
        deleteAction.execute(input, tracker);
        String ln = System.lineSeparator();
        MatcherAssert.assertThat(out.toString(),
                Matchers.is("== Delete item ==" + ln + "Error deleting request." + ln)
        );
        MatcherAssert.assertThat(tracker.findAll().size(), Matchers.is(1));
    }

}