package deque;

public class ArrayDeque<NodeObject> implements Deque<NodeObject> {
    private NodeObject[] itemArray;
    private int begin, end;
    private int arraySize;

    public ArrayDeque() {
        arraySize = 10;
        itemArray = (NodeObject[]) new Object[arraySize * 3];
        begin = end = arraySize;
    }

    /**
     * Resize the array of the array list.
     *
     * @param newArraySize an integer that the minimum size of the array.
     */
    private void resize(int newArraySize) {
        arraySize = newArraySize;
        NodeObject[] newItemArray = (NodeObject[]) new Object[newArraySize * 3];
        int size = this.size();
        System.arraycopy(itemArray, begin, newItemArray, newArraySize, size);
        begin = newArraySize;
        end = newArraySize + size;
        itemArray = newItemArray;
    }

    /**
     * Adds an element to the beginning of the deque.
     *
     * @param item the element want to be added
     */
    @Override
    public void addFirst(NodeObject item) {
        if (begin == 0) {
            resize(this.size());
        }
        begin--;
        itemArray[begin] = item;
    }

    /**
     * Adds an element to the end of the deque.
     *
     * @param item the element want to be added
     */
    @Override
    public void addLast(NodeObject item) {
        if (end == itemArray.length - 1) {
            resize(this.size());
        }
        itemArray[end] = item;
        end++;
    }

    /**
     * Check if the deque is empty.
     *
     * @return a boolean value represents whether the deque is empty
     */
    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    /**
     * Get the size of the deque.
     *
     * @return an integer represents the size of the deque
     */
    @Override
    public int size() {
        return end - begin;
    }

    /**
     * Print the hole deque.
     */
    @Override
    public void printDeque() {
        for (int i = begin; i < end; ++i) {
            System.out.print(itemArray[i] + " ");
        }
        System.out.println();
    }

    /**
     * Remove the first element of the deque.
     *
     * @return the first element being removed
     */
    @Override
    public NodeObject removeFirst() {
        if (this.isEmpty()) {
            return null;
        }
        return itemArray[begin++];
    }

    /**
     * Remove the last element of the deque.
     *
     * @return the last element being removed
     */
    @Override
    public NodeObject removeLast() {
        if (this.isEmpty()) {
            return null;
        }
        return itemArray[--end];
    }

    /**
     * Get the i-th of the element in deque.
     *
     * @param index an integer representing the {@code index}-th element
     * @return the {@code index}-th element
     */
    @Override
    public NodeObject get(int index) {
        return null;
    }
}
