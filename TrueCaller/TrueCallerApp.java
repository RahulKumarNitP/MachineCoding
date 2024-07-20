package TrueCaller;

public class TrueCallerApp {
    public static void main(String[] args) {
        Database database = new Database();

        User user1 = new User("1", "Alice");
        ContactManager contactManager = new ContactManager();
        CallBlocker callBlocker = new CallBlocker();
        CallManager callManager = new CallManager(contactManager, callBlocker);

        Contact contact1 = new Contact("Bob", "1234567890");
        Contact contact2 = new Contact("Charlie", "0987654321");

        contactManager.addContact(contact1);
        contactManager.addContact(contact2);

        user1.addContact(contact1);
        user1.addContact(contact2);

        database.addUser(user1);

        // Simulate incoming call
        callManager.receiveCall("1234567890");

        // Simulate outgoing call
        callManager.makeCall("0987654321");

        // Block a number
        callBlocker.blockNumber("1234567890");

        // Simulate incoming call from blocked number
        callManager.receiveCall("1234567890");

        // Simulate incoming call from another number
        callManager.receiveCall("1234567891");

        // Unblock a number
        callBlocker.unblockNumber("1234567890");

        // Simulate incoming call from recently unblocked number
        callManager.receiveCall("1234567890");

        // Simulate call logs
        System.out.println(callManager.getCallLogs().toString());
    }
}
