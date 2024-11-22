package skiplist;

import java.util.Random;



public class SkipList {
    private static int MAX_LEVEL;
    private final SkipListNode head;
    private int level = 0; // Current max level of the skip list
    private final Random random = new Random();
    public SkipList(int allowedLevel) {
        this.MAX_LEVEL = allowedLevel;
        head = new SkipListNode(-1, MAX_LEVEL);
    }

    // Randomly generates a level for the new node
    private int randomLevel() {
        int level = 0;
        while (random.nextInt(2) == 0 && level < MAX_LEVEL) {
            level++;
        }
        return level;
    }

    // Insert a value into the skip list
    public void insert(int value) {
        SkipListNode[] update = new SkipListNode[MAX_LEVEL + 1];
        SkipListNode current = head;

        // Find the position to insert the new node
        for (int i = level; i >= 0; i--) {
            while (current.forward[i] != null && current.forward[i].value < value) {
                current = current.forward[i];
            }
            update[i] = current;
        }

        int newLevel = randomLevel();
        if (newLevel > level) {
            for (int i = level + 1; i <= newLevel; i++) {
                update[i] = head;
            }
            level = newLevel;
        }

        SkipListNode newNode = new SkipListNode(value, newLevel);
        for (int i = 0; i <= newLevel; i++) {
            newNode.forward[i] = update[i].forward[i];
            update[i].forward[i] = newNode;
        }
    }

    // Delete a value from the skip list
    public void delete(int value) {
        SkipListNode[] update = new SkipListNode[MAX_LEVEL + 1];
        SkipListNode current = head;

        // Find the position of the node to be deleted
        for (int i = level; i >= 0; i--) {
            while (current.forward[i] != null && current.forward[i].value < value) {
                current = current.forward[i];
            }
            update[i] = current;
        }

        current = current.forward[0];
        if (current != null && current.value == value) {
            for (int i = 0; i <= level; i++) {
                if (update[i].forward[i] != current) break;
                update[i].forward[i] = current.forward[i];
            }
            while (level > 0 && head.forward[level] == null) {
                level--;
            }
        }
    }

    // Search for a value in the skip list
    public boolean search(int value) {
        SkipListNode current = head;
        for (int i = level; i >= 0; i--) {
            while (current.forward[i] != null && current.forward[i].value < value) {
                current = current.forward[i];
            }
        }
        current = current.forward[0];
        return current != null && current.value == value;
    }

    // Print the skip list (for debugging purposes)
    public void printList() {
        for (int i = 0; i <= level; i++) {
            SkipListNode node = head.forward[i];
            System.out.print("Level " + i + ": ");
            while (node != null) {
                System.out.print(node.value + " ");
                node = node.forward[i];
            }
            System.out.println();
        }
    }
}
