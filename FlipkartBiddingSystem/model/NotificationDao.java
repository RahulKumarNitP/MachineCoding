package FlipkartBiddingSystem.model;

public class NotificationDao {
    private int notificationId;
    private int userId;
    private String message;
    // Other notification attributes
    
    public NotificationDao(int notificationId, int userId, String message) {
        this.notificationId = notificationId;
        this.userId = userId;
        this.message = message;
    }
    
    // Getters and setters
    public int getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}