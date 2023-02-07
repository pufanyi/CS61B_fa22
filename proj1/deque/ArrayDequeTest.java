package deque;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayDequeTest {
    @Test
    public void addFirstSizeTest() {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        int size = 2333;
        for (int i = 0; i < size; ++i) {
            arrayDeque.addFirst(i);
        }
        assertEquals(size, arrayDeque.size());
    }

    @Test
    public void addLastSizeTest() {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        int size = 2333;
        for (int i = 0; i < size; ++i) {
            arrayDeque.addLast(i);
        }
        assertEquals(size, arrayDeque.size());
    }

    @Test
    public void emptyDequeTest() {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        assertTrue(arrayDeque.isEmpty());
        arrayDeque.addLast(10);
        assertFalse(arrayDeque.isEmpty());
    }

    @Test
    public void addRemoveFountTest() {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        int size = 233;
        for (int i = 1; i <= size; ++i) {
            arrayDeque.addFirst(i);
        }
        for (int i = size; i >= 1; --i) {
            assertEquals(i, (int) arrayDeque.removeFirst());
        }
    }

    @Test
    public void addRemoveLastTest() {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        int size = 233;
        for (int i = 1; i <= size; ++i) {
            arrayDeque.addLast(i);
        }
        for (int i = size; i >= 1; --i) {
            assertEquals(i, (int) arrayDeque.removeLast());
        }
    }

    @Test
    public void removeEmptyTest() {
        ArrayDeque<String> arrayDeque = new ArrayDeque<>();
        arrayDeque.addFirst("a");
        arrayDeque.addFirst("b");
        arrayDeque.removeFirst();
        arrayDeque.removeFirst();
        assertTrue(arrayDeque.isEmpty());
        assertNull(arrayDeque.removeFirst());
        assertNull(arrayDeque.removeLast());
    }

    @Test
    public void multipleParamTest() {

        ArrayDeque<String>  arrayDeque1 = new ArrayDeque<>();
        ArrayDeque<Double>  arrayDeque2 = new ArrayDeque<>();
        ArrayDeque<Boolean> arrayDeque3 = new ArrayDeque<Boolean>();

        arrayDeque1.addFirst("string");
        arrayDeque2.addFirst(3.14159);
        arrayDeque3.addFirst(true);

        String s = arrayDeque1.removeFirst();
        double d = arrayDeque2.removeFirst();
        boolean b = arrayDeque3.removeFirst();
    }

    @Test
    /* Add large number of elements to deque; check if order is correct. */
    public void bigLLDequeTest() {

        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        for (int i = 0; i < 1000000; i++) {
            arrayDeque.addLast(i);
        }

        for (double i = 0; i < 500000; i++) {
            assertEquals("Should have the same value", i, (double) arrayDeque.removeFirst(), 0.0);
        }

        for (double i = 999999; i > 500000; i--) {
            assertEquals("Should have the same value", i, (double) arrayDeque.removeLast(), 0.0);
        }
    }
}
