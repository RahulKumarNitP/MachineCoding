package skiplist;

class SkipListNode {
    int value;
    SkipListNode[] forward; // Array of forward pointers

    public SkipListNode(int value, int level) {
        this.value = value;
        this.forward = new SkipListNode[level + 1];
    }
}