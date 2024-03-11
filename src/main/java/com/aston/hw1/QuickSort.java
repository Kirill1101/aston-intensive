package com.aston.hw1;

import java.util.Comparator;

/**
 * Класс, в котором реализована быстрая сортировка класса MyArrayList
 * с помощью передаваемого компаратора.
 */
public class QuickSort {
    public static <T> void sort(MyArrayList<T> list, Comparator<T> comparator, int l, int r) {
        if (l < r) {
            int pivot = partition(list, comparator, l, r);
            sort(list, comparator, l, pivot - 1);
            sort(list, comparator, pivot + 1, r);
        }
    }

    private static <T> int partition(MyArrayList<T> list, Comparator<T> comparator, int l, int r) {
        T pivot = list.get(r);
        int i = (l - 1);
        for (int j = l; j < r; j++) {
            if (comparator.compare(list.get(j), pivot) < 0) {
                i++;
                swap(list, i, j);
            }
        }
        swap(list, i + 1, r);
        return i + 1;
    }

    private static <T> void swap(MyArrayList<T> list, int i, int j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
