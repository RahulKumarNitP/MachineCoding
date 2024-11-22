package skiplist;

public class Runner {
    public static void main(String[] args) {
        SkipList skipList = new SkipList(2);
        skipList.insert(3);
        skipList.insert(6);
        skipList.insert(7);
        skipList.insert(9);
        skipList.insert(12);
        skipList.insert(19);
        skipList.insert(17);
        skipList.insert(26);
        skipList.insert(21);
        skipList.insert(25);

        System.out.println("Skip List after insertion:");
        skipList.printList();

        skipList.delete(19);
        System.out.println("Skip List after deleting 19:");
        skipList.printList();

        System.out.println("Search for 21: " + skipList.search(21));
        System.out.println("Search for 19: " + skipList.search(19));
    }
}
