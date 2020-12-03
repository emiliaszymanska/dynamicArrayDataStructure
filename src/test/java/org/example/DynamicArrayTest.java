package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DynamicArrayTest {

    @Test
    void DynamicIntArrayTest_WithInitialSize() {
        new DynamicArray(15);
    }

    @Test
    void addTest() {
        DynamicArray array = createArray(11);
        array.add(32);
        array.add(42);
        String result = " 0 1 2 3 4 5 6 7 8 9 10 32 42";
        assertEquals(result, array.toString());
    }

    @Test
    void removeTest() {
        DynamicArray array = createArray(11);
        array.removeAt(5);
        array.removeAt(0);
        String result = " 1 2 3 4 6 7 8 9 10";
        assertEquals(result, array.toString());
    }

    @Test
    void removeTest_LastItem() {
        DynamicArray array = createArray(10);
        array.removeAt(9);
        String result = " 0 1 2 3 4 5 6 7 8";
        assertEquals(result, array.toString());
    }

    @Test
    void removeTest_InvalidItem() {
        DynamicArray array = createArray(10);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> array.removeAt(10));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> array.removeAt(-1));
    }

    @Test
    void insertTest() {
        DynamicArray array = createArray(11);
        array.insertAt(8, 223);
        array.insertAt(100, 654);

        String result = " 0 1 2 3 4 5 6 7 223 8 9 10 654";
        assertEquals(result, array.toString());
    }

    private DynamicArray createArray(int numOfElements) {
        DynamicArray array = new DynamicArray(numOfElements);
        for (int i = 0; i < numOfElements; ++i) {
            array.add(i);
        }
        return array;
    }
}
