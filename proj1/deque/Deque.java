package deque;

public interface Deque<NodeObject> {
    /**
     * Adds an element to the beginning of the deque.
     *
     * @param item the element want to be added
     */
    void addFirst(NodeObject item);

    /**
     * Adds an element to the end of the deque.
     *
     * @param item the element want to be added
     */
    void addLast(NodeObject item);

    /**
     * Check if the deque is empty.
     *
     * @return a boolean value represents whether the deque is empty
     */
    boolean isEmpty();

    /**
     * Get the size of the deque.
     *
     * @return an integer represents the size of the deque
     */
    int size();

    /**
     * Print the hole deque.
     */
    void printDeque();

    /**
     * Remove the first element of the deque.
     *
     * @return the first element being removed
     */
    NodeObject removeFirst();

    /**
     * Remove the last element of the deque.
     *
     * @return the last element being removed
     */
    NodeObject removeLast();

    /**
     * Get the i-th of the element in deque.
     *
     * @param index an integer representing the {@code index}-th element
     * @return the {@code index}-th element
     */
    NodeObject get(int index);
}
