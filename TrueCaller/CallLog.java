package TrueCaller;

import java.time.LocalDateTime;

public class CallLog {
    private String phoneNumber;
    private LocalDateTime callTime;
    private boolean isIncoming;

    public CallLog(String phoneNumber, LocalDateTime callTime, boolean isIncoming) {
        this.phoneNumber = phoneNumber;
        this.callTime = callTime;
        this.isIncoming = isIncoming;
    }

    // Getters and setters
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public LocalDateTime getCallTime() {
        return callTime;
    }

    public boolean isIncoming() {
        return isIncoming;
    }

    @Override
    public String toString() {
        return "CallLog{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", callTime=" + callTime +
                ", isIncoming=" + isIncoming +
                '}';
    }
}
