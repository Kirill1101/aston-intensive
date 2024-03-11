package com.aston.hw1;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Реализация моего списка.
 * @param <T> - параметризованный тип. Альтернативная реализация возможна с "T extends Comparable<T>".
 *          В таком случае для сортировки не требовалось бы передавать компаратор,
 *          но было бы ограничение на реализацию интерфейса Comparable передаваемым типом.
 */
public class MyArrayList<T> implements MyList<T> {

    private Object[] elements = new Object[10];

    private int size = 0;

    /**
     * Добавление одного элемента в конец списка.
     * @param element - элемент.
     */
    public void add(T element) {
        checkCapacity();
        elements[size] = element;
        size++;
    }

    /**
     * Добавление одного элемента по индексу. Смещает элемент, на место которого встает,
     * и все последующие элементы на 1 вправо.
     * @param index - индекс, по которому необходимо вставить элемент.
     * @param element - элемент.
     */
    public void add(int index, T element) {
        checkIndex(index);
        checkCapacity();
        System.arraycopy(elements, index,
                elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }

    /**
     * Замена элемента на дургой.
     * @param index - индекс, по которому надозаменить элемент.
     * @param element - новый элемент.
     */
    public void set(int index, T element) {
        checkIndex(index);
        elements[index] = element;
    }

    /**
     * Получение элемента по индексу.
     * @param index - индекс.
     * @return возвращает элемент, полученный по индексу.
     */
    public T get(int index) {
        checkIndex(index);
        return (T) elements[index];
    }

    /**
     * Удаление элемента по индексу.
     * @param index - индекс.
     */
    public void remove(int index) {
        checkIndex(index);
        if (index != size) {
            System.arraycopy(elements, index + 1,
                    elements, index, size - index);
        }
        size--;
    }

    /**
     * Количесвто элементов в массиве.
     * @return количесвто элементов в массиве.
     */
    public int size() {
        return size;
    }

    /**
     * Удаление всех элементов в массиве.
     */
    public void clear() {
        elements = new Object[10];
        size = 0;
    }

    /**
     * Сортировка, выполненная по алгоритму быстрой сортировки.
     * @param comparator - компаратор, по которому будут сравниваться элементы списка.
     */
    public void sort(Comparator<T> comparator) {
        QuickSort.sort(this, comparator, 0, size - 1);
    }

    /**
     * Вывод списка в консоль.
     */
    public void print() {
        Arrays.stream(elements).limit(size).forEach(System.out::println);
    }

    private void checkIndex(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void checkCapacity() {
        if (size > elements.length * 0.8) {
            expandArray();
        }
    }

    private void expandArray() {
        elements = Arrays.copyOf(elements, (int) (elements.length * 1.5) + 1);
    }
}
