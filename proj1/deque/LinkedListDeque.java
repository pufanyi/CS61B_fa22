package deque;

public class LinkedListDeque<NodeObject> implements Deque<NodeObject> {
    /**
     * The node of the linked list.
     */
    private class ListNode {
        public NodeObject item;
        public ListNode last;
        public ListNode next;

        ListNode() {
            this.next = this;
            this.last = this;
            this.item = null;
        }

        /**
         * @param last the previous node of this node
         * @param next the next node of this node
         * @param item the item stored in the node
         */
        ListNode(ListNode last, ListNode next, NodeObject item) {
            this.item = item;
            this.last = last;
            this.next = next;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof final LinkedListDeque<?>.ListNode that)) {
                return false;
            }
            return this.item.equals(that.item);
        }
    }

    /**
     * The sentinel node of the linked list.
     */
    private final ListNode sentinel;

    /**
     * The size of the linked list.
     */
    private int size;

    /**
     * Get the size of the deque.
     *
     * @return an integer represents the size of the deque
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Check if the deque is empty.
     *
     * @return a boolean value represents whether the deque is empty
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public LinkedListDeque() {
        sentinel = new ListNode();
        size = 0;
    }

    /**
     * Inserts a node at the next position of the current node.
     *
     * @param nowNode the current node
     * @param item    the item want to store in the node
     */
    private void addNext(ListNode nowNode, NodeObject item) {
        this.size++;
        ListNode newNode = new ListNode(nowNode, nowNode.next, item);
        newNode.last.next = newNode.next.last = newNode;
    }

    /**
     * Inserts a node at the previous position of the current node.
     *
     * @param nowNode the current node
     * @param item    the item want to store in the node
     */
    private void addLast(ListNode nowNode, NodeObject item) {
        addNext(nowNode.last, item);
    }

    /**
     * Adds an element to the beginning of the deque.
     *
     * @param item the element want to be added
     */
    @Override
    public void addFirst(NodeObject item) {
        addNext(sentinel, item);
    }

    /**
     * Adds an element to the end of the deque.
     *
     * @param item the element want to be added
     */
    @Override
    public void addLast(NodeObject item) {
        addLast(sentinel, item);
    }

    /**
     * Print the hole deque.
     */
    @Override
    public void printDeque() {
        for (ListNode now = sentinel.next; now != sentinel; now = now.next) {
            System.out.print(now.item + " ");
        }
        System.out.println();
    }

    /**
     * Remove a node from the linked list.
     *
     * @param now the node want to be removed
     * @return the node being removed
     */
    private NodeObject remove(ListNode now) {
        if (now == sentinel) {
            return null;
        }
        this.size--;
        now.next.last = now.last;
        now.last.next = now.next;
        return now.item;
    }

    /**
     * Remove the first element of the deque.
     *
     * @return the first element being removed
     */
    @Override
    public NodeObject removeFirst() {
        return remove(sentinel.next);
    }

    /**
     * Remove the last element of the deque.
     *
     * @return the last element being removed
     */
    @Override
    public NodeObject removeLast() {
        return remove(sentinel.last);
    }


    /**
     * Get the i-th of the element in the linked list.
     *
     * @param index an integer representing the {@code index}-th node
     * @return the {@code index}-th node
     */
    private ListNode getNode(int index) {
        ListNode now = sentinel.next;
        for (int i = 0; i < index; ++i) {
            now = now.next;
        }
        return now;
    }

    /**
     * Get the i-th of the element in deque.
     *
     * @param index an integer representing the {@code index}-th element
     * @return the {@code index}-th element
     */
    @Override
    public NodeObject get(int index) {
        return getNode(index).item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof final LinkedListDeque<?> that)) {
            return false;
        }
        if (this.size() != that.size()) {
            return false;
        }
        for (LinkedListDeque<?>.ListNode nowThis = this.sentinel.next, nowThat = that.sentinel.next;
             nowThis != this.sentinel && nowThat != that.sentinel; nowThis = nowThis.next, nowThat = nowThat.next) {
            if (!nowThis.equals(nowThat)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Get the i-th of the element in the linked list using a recursive method.
     *
     * @param index an integer representing the {@code index}-th node
     * @return the {@code index}-th node
     */
    private ListNode getRecursive(ListNode now, int index) {
        if (index == 0) {
            return now;
        }
        return getRecursive(now.next, index - 1);
    }

    /**
     * Get the i-th of the element in deque using a recursive method.
     *
     * @param index an integer representing the {@code index}-th element
     * @return the {@code index}-th element
     */
    public NodeObject getRecursive(int index) {
        return getRecursive(sentinel.next, index).item;
    }

}
