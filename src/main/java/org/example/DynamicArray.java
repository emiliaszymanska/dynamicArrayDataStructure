package org.example;

import java.util.Arrays;

public class DynamicArray {

    private int size;
    private int capacity;
    private int[] array;

    public DynamicArray(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity cannot be lower than 0.");
        }
        this.size = 0;
        this.capacity = capacity;
        this.array = new int[capacity];
    }

    public int get(int index) {
        rangeCheck(index);
        return array[index];
    }

    public void set(int index, int value) {
        rangeCheck(index);
        array[index] = value;
    }

    public void add(int value) {
        sizeCheck();
        array[size++] = value;
    }

    public void insertAt(int index, int value) {
        if (index < 0) {
            throw new ArrayIndexOutOfBoundsException("Index cannot be lower than 0.");
        }
        if (index > size) {
            index = size;
        }
        sizeCheck();

        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = value;
        size++;
    }

    public void removeAt(int index) {
        rangeCheck(index);
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        int[] newArray = new int[size - 1];
        System.arraycopy(array, 0, newArray, 0, size - 1);
        array = newArray;
        size--;
    }

    private void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Index cannot be lower than 0 and greater than " + (size - 1));
        }
    }

    private void sizeCheck() {
        if (size == capacity) {
            capacity = capacity + 1;
            array = Arrays.copyOf(array, capacity);
        }
    }

    @Override
    public String toString() {
        StringBuilder values = new StringBuilder();
        for (int value : array) {
            values.append(" ").append(value);
        }
        return values.toString();
    }
}
