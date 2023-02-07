package deque;

public class LinkedListDeque<NodeObject> {
    private class ListNode {
        public NodeObject item;
        public ListNode last;
        public ListNode next;

        ListNode() {
            this.next = this;
            this.last = this;
            this.item = null;
        }

        ListNode(ListNode last, ListNode next, NodeObject item) {
            this.item = item;
            this.last = last;
            this.next = next;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof final LinkedListDeque<?>.ListNode that)) {
                return false;
            }
            return this.item.equals(that.item);
        }
    }

    private final ListNode sentinel;
    private int size;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public LinkedListDeque() {
        sentinel = new ListNode();
        size = 0;
    }

    private void addNext(ListNode nowNode, NodeObject item) {
        this.size++;
        ListNode newNode = new ListNode(nowNode, nowNode.next, item);
        newNode.last.next = newNode.next.last = newNode;
    }

    private void addLast(ListNode nowNode, NodeObject item) {
        addNext(nowNode.last, item);
    }

    public void addFirst(NodeObject item) {
        addNext(sentinel, item);
    }

    public void addLast(NodeObject item) {
        addLast(sentinel, item);
    }

    public void printDeque() {
        for (ListNode now = sentinel.next; now != sentinel; now = now.next) {
            System.out.print(now.item + " ");
        }
        System.out.println();
    }

    private NodeObject remove(ListNode now) {
        if (now == sentinel) {
            return null;
        }
        this.size--;
        now.next.last = now.last;
        now.last.next = now.next;
        return now.item;
    }

    public NodeObject removeFirst() {
        NodeObject now = remove(sentinel.next);
        return now;
    }

    public NodeObject removeLast() {
        return remove(sentinel.last);
    }

    private ListNode getNode(int index) {
        ListNode now = sentinel.next;
        for (int i = 0; i < index; ++i) {
            now = now.next;
        }
        return now;
    }

    public NodeObject get(int index) {
        return getNode(index).item;
    }

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

    private ListNode getRecursive(ListNode now, int index) {
        if (index == 0) {
            return now;
        }
        return getRecursive(now.next, index - 1);
    }

    public NodeObject getRecursive(int index) {
        return getRecursive(sentinel.next, index).item;
    }

}
