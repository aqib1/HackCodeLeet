package com.factory;

public class SendNotifications {
    public final NotificationFactory notificationFactory;
    public SendNotifications(NotificationFactory notificationFactory) {
        this.notificationFactory = notificationFactory;
    }

    public void setNotifications() {
        this.notificationFactory.getNotificationType().sendNotifications();
    }
}
