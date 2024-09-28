package ru.job4j.tracker;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FindItemByNameActionTest {

    @Test
    public void whenFindItemByName() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item request = new Item("new Item");
        tracker.add(request);
        FindItemByNameAction findItemByNameAction = new FindItemByNameAction(out);
        Input input = mock(Input.class);
        when(input.askStr(any(String.class))).thenReturn("new Item");
        findItemByNameAction.execute(input, tracker);
        String ln = System.lineSeparator();
        MatcherAssert.assertThat(tracker.findAll().get(0).getName(), Matchers.is("new Item"));
        MatcherAssert.assertThat(out.toString(),
                Matchers.is("== Find items by name ==" + ln + request + ln
        ));
    }

    @Test
    public void whenNoFindItemByName() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item request = new Item("new Item");
        tracker.add(request);
        FindItemByNameAction findItemByNameAction = new FindItemByNameAction(out);
        Input input = mock(Input.class);
        when(input.askStr(any(String.class))).thenReturn("Old Item");
        findItemByNameAction.execute(input, tracker);
        String ln = System.lineSeparator();
        MatcherAssert.assertThat(out.toString(),
                Matchers.is("== Find items by name ==" + ln + "Request with name Old Item not found." + ln
                ));
    }

}