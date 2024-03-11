package com.aston.hw1;

import java.util.Comparator;

/**
 * Интерфейс, который описывает мой список.
 * @param <T> - параметризованный тип
 */
public interface MyList<T> {
    void add(T element);

    void add(int index, T element);

    void set(int index, T element);

    T get(int index);

    void remove(int index);

    int size();

    void clear();

    void print();

    void sort(Comparator<T> comparator);
}
