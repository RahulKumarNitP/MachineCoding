package TrueCaller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CallManager {
    private Stack<CallLog> callLogs;
    private ContactManager contactManager;
    private CallBlocker callBlocker;

    public CallManager(ContactManager contactManager, CallBlocker callBlocker) {
        this.callLogs = new Stack<>();
        this.contactManager = contactManager;
        this.callBlocker = callBlocker;
    }

    public void receiveCall(String phoneNumber) {
        if (callBlocker.isBlocked(phoneNumber)) {
            System.out.println("Blocked call from: " + phoneNumber);
        } else {
            Contact contact = contactManager.getContactByPhoneNumber(phoneNumber);
            if (contact != null) {
                System.out.println("Incoming call from: " + contact.getName());
            } else {
                System.out.println("Incoming call from unknown number: " + phoneNumber);
            }
            logCall(phoneNumber, true);
        }
    }

    public void makeCall(String phoneNumber) {
        System.out.println("Calling: " + phoneNumber);
        logCall(phoneNumber, false);
    }

    private void logCall(String phoneNumber, boolean isIncoming) {
        CallLog callLog = new CallLog(phoneNumber, LocalDateTime.now(), isIncoming);
        callLogs.add(callLog);
    }

    public Stack<CallLog> getCallLogs() {
        return callLogs;
    }
}
