package ru.job4j.tracker;

import org.junit.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;

public class ItemDescByNameTest {

    @Test
    public void whenSortDesc() {
        List<Item> items = Arrays.asList(
                new Item(1, "Aris"),
                new Item(10, "Crot"),
                new Item(5, "Bin")
        );
        List<Item> expected = Arrays.asList(
                new Item(10, "Crot"),
                new Item(5, "Bin"),
                new Item(1, "Aris")
        );
        Collections.sort(items, new ItemDescByName());
        assertEquals(expected, items);
    }

}