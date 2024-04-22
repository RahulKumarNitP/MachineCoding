package FlipkartBiddingSystem.service;

import FlipkartBiddingSystem.model.NotificationDao;

public interface Notification {
    public void sendNotification(NotificationDao notificationDao);
}
