package ru.job4j.search;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PriorityQueueTest {

    @Test
    public void whenHigherPriority() {
        var queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent2", 3));
        queue.put(new Task("mid", 10));
        queue.put(new Task("middle", 5));
        queue.put(new Task("urgent", 3));
        var result = queue.take();
        assertThat(result.getDesc(), is("urgent2"));
    }

}