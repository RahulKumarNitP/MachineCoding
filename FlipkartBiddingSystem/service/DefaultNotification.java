package FlipkartBiddingSystem.service;

import FlipkartBiddingSystem.model.NotificationDao;
import FlipkartBiddingSystem.service.Notification;

public class DefaultNotification implements Notification {
    @Override
    public void sendNotification(NotificationDao notificationDao) {
        System.out.println("Notification sent to user " + notificationDao.getUserId() + ": " + notificationDao.getMessage());
    }
}
