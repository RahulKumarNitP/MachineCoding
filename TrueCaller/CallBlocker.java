package TrueCaller;

import java.util.HashSet;
import java.util.Set;

public class CallBlocker {
    private Set<String> blockedNumbers;

    public CallBlocker() {
        this.blockedNumbers = new HashSet<>();
    }

    public void blockNumber(String phoneNumber) {
        System.out.println("Blocked number " + phoneNumber);
        blockedNumbers.add(phoneNumber);
    }

    public boolean isBlocked(String phoneNumber) {
        return blockedNumbers.contains(phoneNumber);
    }

    public void unblockNumber(String phoneNumber) {
        blockedNumbers.remove(phoneNumber);
    }
}
