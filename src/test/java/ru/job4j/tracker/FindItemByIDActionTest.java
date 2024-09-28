package ru.job4j.tracker;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FindItemByIDActionTest {

    @Test
    public void whenFindItemById() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item request = new Item("new Item");
        tracker.add(request);
        FindItemByIDAction findItemByIDAction = new FindItemByIDAction(out);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        findItemByIDAction.execute(input, tracker);
        String ln = System.lineSeparator();
        MatcherAssert.assertThat(tracker.findAll().get(0).getName(), Matchers.is("new Item"));
        MatcherAssert.assertThat(out.toString(),
                Matchers.is("== Find items by id ==" + ln + request + ln
                ));
    }

    @Test
    public void whenNoFindItemById() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item request = new Item("new Item");
        tracker.add(request);
        FindItemByIDAction findItemByIDAction = new FindItemByIDAction(out);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(2);
        findItemByIDAction.execute(input, tracker);
        String ln = System.lineSeparator();
        MatcherAssert.assertThat(tracker.findAll().get(0).getName(), Matchers.is("new Item"));
        MatcherAssert.assertThat(out.toString(),
                Matchers.is("== Find items by id ==" + ln + "Request with id 2 not found." + ln
                ));
    }

}