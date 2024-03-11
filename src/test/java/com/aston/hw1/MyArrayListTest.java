package com.aston.hw1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyArrayListTest {
    @Test
    public void add_WithAnyTypeOfElement_ShouldAddElementToList() {
        MyList<Integer> listInteger = new MyArrayList<>();
        listInteger.add(3);
        assertEquals(listInteger.get(0), 3);

        MyList<String> listString = new MyArrayList<>();
        listString.add("3");
        assertEquals(listString.get(0), "3");

        MyList<Double> listDouble = new MyArrayList<>();
        listDouble.add(1.2);
        assertEquals(listDouble.get(0), 1.2);
    }

    @Test
    public void add_WithIndexLessThanZero_ShouldThrowIndexOutOfBoundException() {
        MyList<Integer> listInteger = new MyArrayList<>();
        listInteger.add(1);
        assertThrows(IndexOutOfBoundsException.class,
                () -> listInteger.add(-1, 2));
    }

    @Test
    public void add_WithIndexMoreThanSize_ShouldThrowIndexOutOfBoundException() {
        MyList<Integer> listInteger = new MyArrayList<>();
        listInteger.add(1);
        assertThrows(IndexOutOfBoundsException.class,
                () -> listInteger.add(2, 2));
    }

    @Test
    public void add_WithCorrectIndex_ShouldInsertElementByIndexAndShiftOtherElements() {
        MyList<Integer> listInteger = new MyArrayList<>();
        listInteger.add(1);
        listInteger.add(2);
        listInteger.add(3);
        listInteger.add(2,0);

        assertEquals(listInteger.size(), 4);
        assertEquals(listInteger.get(0), 1);
        assertEquals(listInteger.get(1), 2);
        assertEquals(listInteger.get(2), 0);
        assertEquals(listInteger.get(3), 3);
    }

    @Test
    public void set_WithIndexMoreThanSize_ShouldThrowIndexOutOfBoundException() {
        MyList<Integer> listInteger = new MyArrayList<>();
        listInteger.add(1);
        assertThrows(IndexOutOfBoundsException.class,
                () -> listInteger.set(2, 2));
    }

    @Test
    public void set_WithCorrectIndex_ShouldReplaceElementByIndex() {
        MyList<Integer> listInteger = new MyArrayList<>();
        listInteger.add(1);
        listInteger.set(0, 2);
        assertEquals(listInteger.get(0), 2);
    }

    @Test
    public void get_WithIndexMoreThanSize_ShouldThrowIndexOutOfBoundException() {
        MyList<Integer> listInteger = new MyArrayList<>();
        listInteger.add(1);
        assertThrows(IndexOutOfBoundsException.class,
                () -> listInteger.get(1));
    }

    @Test
    public void get_WithCorrectIndex_ShouldReturnCorrectElement() {
        MyList<Integer> listInteger = new MyArrayList<>();
        listInteger.add(1);
        assertEquals(listInteger.get(0), 1);
    }

    @Test
    public void remove_WithCorrectIndex_ShouldRemoveElement() {
        MyList<Integer> listInteger = new MyArrayList<>();
        listInteger.add(1);
        listInteger.remove(0);
        assertEquals(listInteger.size(), 0);
    }

    @Test
    public void size_ShouldReturnCurrentListSize() {
        MyList<Integer> listInteger = new MyArrayList<>();
        listInteger.add(1);
        listInteger.add(0, 2);
        listInteger.remove(0);
        listInteger.add(1);
        assertEquals(listInteger.size(), 2);
    }

    @Test
    public void clear_ShouldRemoveAllElements() {
        MyList<Integer> listInteger = new MyArrayList<>();
        listInteger.add(1);
        listInteger.add(0, 2);
        listInteger.add(1);
        listInteger.clear();
        assertEquals(listInteger.size(), 0);
    }

    @Test
    public void sort_ShouldReturnCurrentListSize() {
        MyList<Integer> listInteger = new MyArrayList<>();
        listInteger.add(3);
        listInteger.add(2);
        listInteger.add(-2);
        listInteger.add(3);
        listInteger.add(-10);
        listInteger.sort(Integer::compareTo);
        for (int i = 0; i < listInteger.size() - 2; ++i) {
            assertTrue(listInteger.get(i) < listInteger.get(i + 1));
        }
    }
}
